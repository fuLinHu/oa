package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TGroupResource;
import com.hacker.oa.service.TGroupResourceService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tGroupResource")
public class TGroupResourceController  {

	@Resource(name = "tGroupResourceService")
	private TGroupResourceService tGroupResourceService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
    public String all() throws Exception {
        return "t_group_resource_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TGroupResource tGroupResourceWhere) throws Exception {
    	Assert.notNull(tGroupResourceWhere);
		TGroupResource tGroupResource = (TGroupResource) tGroupResourceWhere;
    	if (tGroupResourceWhere.getId() == null) {
			tGroupResourceService.insert(tGroupResourceWhere);
    	} else {
			tGroupResourceService.updateById(tGroupResourceWhere);
    	}
    	return "redirect:/tgroupresource/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public Object saveJson(@ModelAttribute TGroupResource tGroupResourceWhere) throws Exception {
    	Assert.notNull(tGroupResourceWhere);
    	TGroupResource tGroupResource = (TGroupResource) tGroupResourceWhere;
    	if (tGroupResourceWhere.getId() == null) {
			tGroupResourceService.insert(tGroupResourceWhere);
		} else {
			tGroupResourceService.updateById(tGroupResourceWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TGroupResource tGroupResource = tGroupResourceService.getById(id);
    	model.addAttribute("tGroupResource", tGroupResource);
        return "tgroupresource/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TGroupResource tGroupResource = tGroupResourceService.getById(id);
    	model.addAttribute("tGroupResource", tGroupResource);
        return "tgroupresource/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public Object viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TGroupResource tGroupResource = tGroupResourceService.getById(id);
    	return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tGroupResource)
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TGroupResource tGroupResourceWhere, Model model) {
		tGroupResourceWhere.setOrder("Id desc");
		PageResult<TGroupResource> tGroupResources = tGroupResourceService.findByTGroupResourceWhere(tGroupResourceWhere);
		model.addAttribute("tGroupResources", tGroupResources);
		return "tgroupresource/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public Object listJson(@ModelAttribute TGroupResource tGroupResourceWhere, Model model) {
		tGroupResourceWhere.setOrder("Id desc");
		PageResult<TGroupResource> tGroupResources = tGroupResourceService.findByTGroupResourceWhere(tGroupResourceWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tGroupResources)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public Object deleteJsonById(@PathVariable("id")Integer id) {
		TGroupResource tgroupresource = tGroupResourceService.getById(id);
        Assert.notNull(tgroupresource);
		tGroupResourceService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}