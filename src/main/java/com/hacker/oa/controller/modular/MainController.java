package com.hacker.oa.controller.modular;

import com.hacker.oa.bean.TreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("/tree")
    @ResponseBody
    public List<TreeNode> getTreeNode(TreeNode node){

        return null;
    }
}
