package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.entity.TSalary;
import com.hacker.oa.entity.where.TSalaryWhere;
import com.hacker.oa.service.TSalaryService;
import javax.annotation.Resource;
import ldh.common.PageResult;
import ldh.common.json.JsonViewFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tSalary")
public class TSalaryController  {

	@Resource(name = "tSalaryService")
	private TSalaryService tSalaryService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
    public String all() throws Exception {
        return "t_salary_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TSalaryWhere tSalaryWhere) throws Exception {
    	Assert.notNull(tSalaryWhere);
		TSalary tSalary = (TSalary) tSalaryWhere;
    	if (tSalaryWhere.getId() == null) {
			tSalaryService.insert(tSalaryWhere);
    	} else {
			tSalaryService.updateById(tSalaryWhere);
    	}
    	return "redirect:/tsalary/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute TSalaryWhere tSalaryWhere) throws Exception {
    	Assert.notNull(tSalaryWhere);
    	TSalary tSalary = (TSalary) tSalaryWhere;
    	if (tSalaryWhere.getId() == null) {
			tSalaryService.insert(tSalaryWhere);
		} else {
			tSalaryService.updateById(tSalaryWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TSalary tSalary = tSalaryService.getById(id);
    	model.addAttribute("tSalary", tSalary);
        return "tsalary/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TSalary tSalary = tSalaryService.getById(id);
    	model.addAttribute("tSalary", tSalary);
        return "tsalary/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TSalary tSalary = tSalaryService.getById(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tSalary)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TSalaryWhere tSalaryWhere, Model model) {
		tSalaryWhere.setOrder("ID desc");
		PageResult<TSalary> tSalarys = tSalaryService.findByTSalaryWhere(tSalaryWhere);
		model.addAttribute("tSalarys", tSalarys);
		return "tsalary/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute TSalaryWhere tSalaryWhere, Model model) {
		tSalaryWhere.setOrder("ID desc");
		PageResult<TSalary> tSalarys = tSalaryService.findByTSalaryWhere(tSalaryWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tSalarys)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public String deleteJsonById(@PathVariable("id")Integer id) {
		TSalary tsalary = tSalaryService.getById(id);
        Assert.notNull(tsalary);
		tSalaryService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}