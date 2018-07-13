package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.entity.SuperviseReceive;
import com.hacker.oa.entity.where.SuperviseReceiveWhere;
import com.hacker.oa.service.SuperviseReceiveService;
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
@RequestMapping("superviseReceive")
public class SuperviseReceiveController  {

	@Resource(name = "superviseReceiveService")
	private SuperviseReceiveService superviseReceiveService;
	
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
        return "supervise_receive_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute SuperviseReceiveWhere superviseReceiveWhere) throws Exception {
    	Assert.notNull(superviseReceiveWhere);
		SuperviseReceive superviseReceive = (SuperviseReceive) superviseReceiveWhere;
    	if (superviseReceiveWhere.getId() == null) {
			superviseReceiveService.insert(superviseReceiveWhere);
    	} else {
			superviseReceiveService.updateById(superviseReceiveWhere);
    	}
    	return "redirect:/supervisereceive/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute SuperviseReceiveWhere superviseReceiveWhere) throws Exception {
    	Assert.notNull(superviseReceiveWhere);
    	SuperviseReceive superviseReceive = (SuperviseReceive) superviseReceiveWhere;
    	if (superviseReceiveWhere.getId() == null) {
			superviseReceiveService.insert(superviseReceiveWhere);
		} else {
			superviseReceiveService.updateById(superviseReceiveWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		SuperviseReceive superviseReceive = superviseReceiveService.getById(id);
    	model.addAttribute("superviseReceive", superviseReceive);
        return "supervisereceive/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	SuperviseReceive superviseReceive = superviseReceiveService.getById(id);
    	model.addAttribute("superviseReceive", superviseReceive);
        return "supervisereceive/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	SuperviseReceive superviseReceive = superviseReceiveService.getById(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", superviseReceive)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute SuperviseReceiveWhere superviseReceiveWhere, Model model) {
		superviseReceiveWhere.setOrder("ID desc");
		PageResult<SuperviseReceive> superviseReceives = superviseReceiveService.findBySuperviseReceiveWhere(superviseReceiveWhere);
		model.addAttribute("superviseReceives", superviseReceives);
		return "supervisereceive/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute SuperviseReceiveWhere superviseReceiveWhere, Model model) {
		superviseReceiveWhere.setOrder("ID desc");
		PageResult<SuperviseReceive> superviseReceives = superviseReceiveService.findBySuperviseReceiveWhere(superviseReceiveWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", superviseReceives)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public String deleteJsonById(@PathVariable("id")Integer id) {
		SuperviseReceive supervisereceive = superviseReceiveService.getById(id);
        Assert.notNull(supervisereceive);
		superviseReceiveService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}