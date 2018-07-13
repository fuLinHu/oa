package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.entity.TExpenseAccount;
import com.hacker.oa.entity.where.TExpenseAccountWhere;
import com.hacker.oa.service.TExpenseAccountService;
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
@RequestMapping("tExpenseAccount")
public class TExpenseAccountController  {

	@Resource(name = "tExpenseAccountService")
	private TExpenseAccountService tExpenseAccountService;
	
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
        return "t_expense_account_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TExpenseAccountWhere tExpenseAccountWhere) throws Exception {
    	Assert.notNull(tExpenseAccountWhere);
		TExpenseAccount tExpenseAccount = (TExpenseAccount) tExpenseAccountWhere;
    	if (tExpenseAccountWhere.getId() == null) {
			tExpenseAccountService.insert(tExpenseAccountWhere);
    	} else {
			tExpenseAccountService.updateById(tExpenseAccountWhere);
    	}
    	return "redirect:/texpenseaccount/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute TExpenseAccountWhere tExpenseAccountWhere) throws Exception {
    	Assert.notNull(tExpenseAccountWhere);
    	TExpenseAccount tExpenseAccount = (TExpenseAccount) tExpenseAccountWhere;
    	if (tExpenseAccountWhere.getId() == null) {
			tExpenseAccountService.insert(tExpenseAccountWhere);
		} else {
			tExpenseAccountService.updateById(tExpenseAccountWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TExpenseAccount tExpenseAccount = tExpenseAccountService.getById(id);
    	model.addAttribute("tExpenseAccount", tExpenseAccount);
        return "texpenseaccount/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TExpenseAccount tExpenseAccount = tExpenseAccountService.getById(id);
    	model.addAttribute("tExpenseAccount", tExpenseAccount);
        return "texpenseaccount/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TExpenseAccount tExpenseAccount = tExpenseAccountService.getById(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tExpenseAccount)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TExpenseAccountWhere tExpenseAccountWhere, Model model) {
		tExpenseAccountWhere.setOrder("ID desc");
		PageResult<TExpenseAccount> tExpenseAccounts = tExpenseAccountService.findByTExpenseAccountWhere(tExpenseAccountWhere);
		model.addAttribute("tExpenseAccounts", tExpenseAccounts);
		return "texpenseaccount/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute TExpenseAccountWhere tExpenseAccountWhere, Model model) {
		tExpenseAccountWhere.setOrder("ID desc");
		PageResult<TExpenseAccount> tExpenseAccounts = tExpenseAccountService.findByTExpenseAccountWhere(tExpenseAccountWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tExpenseAccounts)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public String deleteJsonById(@PathVariable("id")Integer id) {
		TExpenseAccount texpenseaccount = tExpenseAccountService.getById(id);
        Assert.notNull(texpenseaccount);
		tExpenseAccountService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}