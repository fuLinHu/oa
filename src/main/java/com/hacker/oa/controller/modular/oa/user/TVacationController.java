package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.DateEditor;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TVacation;
import com.hacker.oa.service.TVacationService;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("tVacation")
public class TVacationController  {

	@Resource(name = "tVacationService")
	private TVacationService tVacationService;
	
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
        return "t_vacation_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TVacation tVacationWhere) throws Exception {
    	Assert.notNull(tVacationWhere);
		TVacation tVacation = (TVacation) tVacationWhere;
    	if (tVacationWhere.getId() == null) {
			tVacationService.insert(tVacationWhere);
    	} else {
			tVacationService.updateById(tVacationWhere);
    	}
    	return "redirect:/tvacation/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute TVacation tVacationWhere) throws Exception {
    	Assert.notNull(tVacationWhere);
    	TVacation tVacation = (TVacation) tVacationWhere;
    	if (tVacationWhere.getId() == null) {
			tVacationService.insert(tVacationWhere);
		} else {
			tVacationService.updateById(tVacationWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TVacation tVacation = tVacationService.getById(id);
    	model.addAttribute("tVacation", tVacation);
        return "tvacation/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TVacation tVacation = tVacationService.getById(id);
    	model.addAttribute("tVacation", tVacation);
        return "tvacation/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TVacation tVacation = tVacationService.getById(id);
    	return JsonViewFactory.create()
				/*.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tVacation)*/
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TVacation tVacationWhere, Model model) {
		tVacationWhere.setOrder("ID desc");
		PageResult<TVacation> tVacations = tVacationService.findByTVacationWhere(tVacationWhere);
		model.addAttribute("tVacations", tVacations);
		return "tvacation/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute TVacation tVacationWhere, Model model) {
		tVacationWhere.setOrder("ID desc");
		PageResult<TVacation> tVacations = tVacationService.findByTVacationWhere(tVacationWhere);
		return JsonViewFactory.create()
				/*.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tVacations)*/
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public String deleteJsonById(@PathVariable("id")Integer id) {
		TVacation tvacation = tVacationService.getById(id);
        Assert.notNull(tvacation);
		tVacationService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}