package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.DateEditor;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TSalaryAdjust;
import com.hacker.oa.service.TSalaryAdjustService;
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
@RequestMapping("tSalaryAdjust")
public class TSalaryAdjustController  {

	@Resource(name = "tSalaryAdjustService")
	private TSalaryAdjustService tSalaryAdjustService;
	
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
        return "t_salary_adjust_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TSalaryAdjust tSalaryAdjustWhere) throws Exception {
    	Assert.notNull(tSalaryAdjustWhere);
		TSalaryAdjust tSalaryAdjust = (TSalaryAdjust) tSalaryAdjustWhere;
    	if (tSalaryAdjustWhere.getId() == null) {
			tSalaryAdjustService.insert(tSalaryAdjustWhere);
    	} else {
			tSalaryAdjustService.updateById(tSalaryAdjustWhere);
    	}
    	return "redirect:/tsalaryadjust/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public Object saveJson(@ModelAttribute TSalaryAdjust tSalaryAdjustWhere) throws Exception {
    	Assert.notNull(tSalaryAdjustWhere);
    	TSalaryAdjust tSalaryAdjust = (TSalaryAdjust) tSalaryAdjustWhere;
    	if (tSalaryAdjustWhere.getId() == null) {
			tSalaryAdjustService.insert(tSalaryAdjustWhere);
		} else {
			tSalaryAdjustService.updateById(tSalaryAdjustWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TSalaryAdjust tSalaryAdjust = tSalaryAdjustService.getById(id);
    	model.addAttribute("tSalaryAdjust", tSalaryAdjust);
        return "tsalaryadjust/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TSalaryAdjust tSalaryAdjust = tSalaryAdjustService.getById(id);
    	model.addAttribute("tSalaryAdjust", tSalaryAdjust);
        return "tsalaryadjust/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public Object viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TSalaryAdjust tSalaryAdjust = tSalaryAdjustService.getById(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tSalaryAdjust)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TSalaryAdjust tSalaryAdjustWhere, Model model) {
		tSalaryAdjustWhere.setOrder("ID desc");
		PageResult<TSalaryAdjust> tSalaryAdjusts = tSalaryAdjustService.findByTSalaryAdjustWhere(tSalaryAdjustWhere);
		model.addAttribute("tSalaryAdjusts", tSalaryAdjusts);
		return "tsalaryadjust/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public Object listJson(@ModelAttribute TSalaryAdjust tSalaryAdjustWhere, Model model) {
		tSalaryAdjustWhere.setOrder("ID desc");
		PageResult<TSalaryAdjust> tSalaryAdjusts = tSalaryAdjustService.findByTSalaryAdjustWhere(tSalaryAdjustWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tSalaryAdjusts)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public Object deleteJsonById(@PathVariable("id")Integer id) {
		TSalaryAdjust tsalaryadjust = tSalaryAdjustService.getById(id);
        Assert.notNull(tsalaryadjust);
		tSalaryAdjustService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}