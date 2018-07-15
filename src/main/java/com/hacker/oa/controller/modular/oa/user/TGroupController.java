package com.hacker.oa.controller.modular.oa.user;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TGroup;
import com.hacker.oa.service.TGroupService;
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
@RequestMapping("tGroup")
public class TGroupController  {

	@Resource(name = "tGroupService")
	private TGroupService tGroupService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
    public String all() throws Exception {
        return "t_group_all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute TGroup tGroupWhere) throws Exception {
    	Assert.notNull(tGroupWhere);
		TGroup tGroup = (TGroup) tGroupWhere;
    	if (tGroupWhere.getGroupId() == null) {
			tGroupService.insert(tGroupWhere);
    	} else {
			tGroupService.updateByGroupId(tGroupWhere);
    	}
    	return "redirect:/tgroup/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save/json")
    @ResponseBody
    public String saveJson(@ModelAttribute TGroup tGroupWhere) throws Exception {
    	Assert.notNull(tGroupWhere);
    	TGroup tGroup = (TGroup) tGroupWhere;
    	if (tGroupWhere.getGroupId() == null) {
			tGroupService.insert(tGroupWhere);
		} else {
			tGroupService.updateByGroupId(tGroupWhere);
		}
        return JsonViewFactory.create()
				.toJson();
    }

	
	@RequestMapping(method = RequestMethod.GET, value = "/toEdit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) throws Exception {
		TGroup tGroup = tGroupService.getByGroupId(id);
    	model.addAttribute("tGroup", tGroup);
        return "tgroup/edit";
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/view/{id}")
    public String view(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TGroup tGroup = tGroupService.getByGroupId(id);
    	model.addAttribute("tGroup", tGroup);
        return "tgroup/view";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/view/json/{id}")
    @ResponseBody
    public String viewJson(@PathVariable Integer id, Model model) throws Exception {
    	Assert.notNull(id);
    	TGroup tGroup = tGroupService.getByGroupId(id);
    	return JsonViewFactory.create()
				/*.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tGroup)*/
				.toJson();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(@ModelAttribute TGroup tGroupWhere, Model model) {
		tGroupWhere.setOrder("GROUP_ID desc");
		PageResult<TGroup> tGroups = tGroupService.findByTGroupWhere(tGroupWhere);
		model.addAttribute("tGroups", tGroups);
		return "tgroup/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list/json")
	@ResponseBody
	public String listJson(@ModelAttribute TGroup tGroupWhere, Model model) {
		tGroupWhere.setOrder("GROUP_ID desc");
		PageResult<TGroup> tGroups = tGroupService.findByTGroupWhere(tGroupWhere);
		return JsonViewFactory.create()
				/*.setDateFormat("yyyy-MM-dd hh:mm:ss")
				.put("data", tGroups)*/
				.toJson();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteByGroupId/json/{groupId}")
	@ResponseBody
	public String deleteJsonByGroupId(@PathVariable("groupId")Integer groupId) {
		TGroup tgroup = tGroupService.getByGroupId(groupId);
        Assert.notNull(tgroup);
		tGroupService.deleteByGroupId(groupId);
        return JsonViewFactory.create()
				.toJson();
        }

	
}