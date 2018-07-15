package com.hacker.oa.controller.modular;

import com.hacker.oa.bean.PageResult;
import com.hacker.oa.bean.TreeNode;
import com.hacker.oa.entity.TResource;
import com.hacker.oa.service.TResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private TResourceService tResourceService;
    
    @RequestMapping("/tree")
    @ResponseBody
    public List<TreeNode> getTreeNode(TreeNode node){
        TResource resource = new TResource();
        PageResult<TResource> byTResourceWhere = tResourceService.findByTResourceWhere(resource);
        List<TResource> imageList = byTResourceWhere.getImageList();
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        for(TResource item:imageList){
            TreeNode treeNode = new TreeNode();
            treeNode.setId(item.getId()+"");
            treeNode.setpId(item.getParentId()+"");
            treeNode.setName(item.getName());
            treeList.add(treeNode);
        }
        return treeList;
    }
}
