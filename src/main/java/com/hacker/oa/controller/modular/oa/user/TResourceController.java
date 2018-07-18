package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TResource;
import com.hacker.oa.service.TResourceService;
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
@RequestMapping("tResource")
public class TResourceController  {

	@Resource(name = "tResourceService")
	private TResourceService tResourceService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
    public String all() throws Exception {
        return "t_resource_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TResource tResourceWhere) throws Exception {
    	Assert.notNull(tResourceWhere);
		TResource tResource = (TResource) tResourceWhere;
    	if (tResourceWhere.getId() == null) {
			tResourceService.insert(tResourceWhere);
    	} else {
			tResourceService.updateById(tResourceWhere);
    	}
    	return "redirect:/tresource/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public Object saveJson(@ModelAttribute TResource tResourceWhere) throws Exception {
    	Assert.notNull(tResourceWhere);
    	TResource tResource = (TResource) tResourceWhere;
    	if (tResourceWhere.getId() == null) {
			tResourceService.insert(tResourceWhere);
		} else {
			tResourceService.updateById(tResourceWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TResource tResource = tResourceService.getById(id);
    	model.addAttribute("tResource", tResource);
        return "tresource/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TResource tResource = tResourceService.getById(id);
    	model.addAttribute("tResource", tResource);
        return "tresource/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public Object viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TResource tResource = tResourceService.getById(id);
    	return JsonViewFactory.create()
				/*.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tResource)*/
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TResource tResourceWhere, Model model) {
		tResourceWhere.setOrder("id desc");
		PageResult<TResource> tResources = tResourceService.findByTResourceWhere(tResourceWhere);
		model.addAttribute("tResources", tResources);
		return "tresource/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public Object listJson(@ModelAttribute TResource tResourceWhere, Model model) {
		tResourceWhere.setOrder("id desc");
		PageResult<TResource> tResources = tResourceService.findByTResourceWhere(tResourceWhere);
		return JsonViewFactory.create()
				.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tResources)
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteById/json/{id}")
	@ResponseBody
	public Object deleteJsonById(@PathVariable("id")Integer id) {
		TResource tresource = tResourceService.getById(id);
        Assert.notNull(tresource);
		tResourceService.deleteById(id);
        return JsonViewFactory.create()
				.toJson();
        }

	
}