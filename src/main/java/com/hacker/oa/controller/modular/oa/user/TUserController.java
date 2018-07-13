package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.entity.TUser;
import com.hacker.oa.entity.where.TUserWhere;
import com.hacker.oa.service.TUserService;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import ldh.common.PageResult;
import ldh.common.json.JsonViewFactory;
import ldh.common.mvc.DateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tUser")
public class TUserController  {

	@Resource(name = "tUserService")
	private TUserService tUserService;
	
	/**
	 * 字符串转化成时间
	 */
	@InitBinder  
	protected void initBinder(HttpServletRequest request,  
	                              ServletRequestDataBinder binder) throws Exception {  
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理  
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	} 
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
    public String all() throws Exception {
        return "t_user_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TUserWhere tUserWhere) throws Exception {
    	Assert.notNull(tUserWhere);
		TUser tUser = (TUser) tUserWhere;
    	if (tUserWhere.getUserId() == null) {
			tUserService.insert(tUserWhere);
    	} else {
			tUserService.updateByUserId(tUserWhere);
    	}
    	return "redirect:/tuser/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute TUserWhere tUserWhere) throws Exception {
    	Assert.notNull(tUserWhere);
    	TUser tUser = (TUser) tUserWhere;
    	if (tUserWhere.getUserId() == null) {
			tUserService.insert(tUserWhere);
		} else {
			tUserService.updateByUserId(tUserWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TUser tUser = tUserService.getByUserId(id);
    	model.addAttribute("tUser", tUser);
        return "tuser/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TUser tUser = tUserService.getByUserId(id);
    	model.addAttribute("tUser", tUser);
        return "tuser/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TUser tUser = tUserService.getByUserId(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tUser)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TUserWhere tUserWhere, Model model) {
		tUserWhere.setOrder("USER_ID desc");
		PageResult<TUser> tUsers = tUserService.findJoinByTUserWhere(tUserWhere);
		model.addAttribute("tUsers", tUsers);
		return "tuser/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute TUserWhere tUserWhere, Model model) {
		tUserWhere.setOrder("USER_ID desc");
		PageResult<TUser> tUsers = tUserService.findJoinByTUserWhere(tUserWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tUsers)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteByUserId/json/{userId}")
	@ResponseBody
	public String deleteJsonByUserId(@PathVariable("userId")Integer userId) {
		TUser tuser = tUserService.getByUserId(userId);
        Assert.notNull(tuser);
		tUserService.deleteByUserId(userId);
        return JsonViewFactory.create()
				.toJson();
        }

	
}