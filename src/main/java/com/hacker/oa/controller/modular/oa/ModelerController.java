package com.hacker.oa.controller.modular.oa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hacker.oa.bean.PageResult;
import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.entity.TExpenseAccount;
import com.hacker.oa.util.Status;
import com.hacker.oa.util.ToWeb;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by liuruijie on 2017/4/20.
 * 模型管理
 */
@Controller
@RequestMapping("models")
public class ModelerController {
    private static final Logger logger = Logger.getLogger(ProcessController.class);

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 新建一个空模型
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("newModel")
    public String newModel() throws UnsupportedEncodingException {
        //初始化一个空模型
        Model model = repositoryService.newModel();
        //设置一些默认信息
        String name = "new-process";
        String description = "";

        int revision = 1;
        String key = "process";

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());
        repositoryService.saveModel(model);
        String id = model.getId();
        //完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes("utf-8"));
        return "redirect:/activitiEdit?modelId="+id;
    }
    @RequestMapping("/pageList")
    @ResponseBody
    public Object getList(@RequestParam(value = "rowSize", defaultValue = "10", required = false) Integer rowSize, @RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
        List<Model> list = repositoryService.createModelQuery().listPage(rowSize * (page - 1), rowSize);
        long count = repositoryService.createModelQuery().count();
        return list;
    }
    @RequestMapping("/modelList")
    public String toModelList(){
        return "/oa/modelList";
    }
    /**
     * 部署流程
     * @param modelId
     * @return
     */
    @RequestMapping(value = "deploy/{id}")
    @ResponseBody
    public Object deploy(@PathVariable("id") String modelId) {
        JsonViewFactory jsonViewFactory = JsonViewFactory.create();
        try {
            Model modelData = repositoryService.getModel(modelId);
            ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;

            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);

            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName()).addString(processName, new String(bpmnBytes)).deploy();
        } catch (Exception e) {
            jsonViewFactory.setStatus(jsonViewFactory.ERRORSTATUS);
            jsonViewFactory.setSuccess(false);
            jsonViewFactory.setMessage("根据模型部署流程失败!");
            logger.error("根据模型部署流程失败：modelId={}" + modelId, e);
        }
        return jsonViewFactory.toJson();
    }
    @RequestMapping(value = "delete/{modelId}")
    @ResponseBody
    public Object delete(@PathVariable("modelId") String modelId) {
        JsonViewFactory jsonViewFactory = JsonViewFactory.create();
        try {
            repositoryService.deleteModel(modelId);
            jsonViewFactory.setMessage("删除成功！");
        } catch (Exception e) {
            jsonViewFactory.setStatus(jsonViewFactory.ERRORSTATUS);
            jsonViewFactory.setSuccess(false);
            jsonViewFactory.setMessage("删除失败！");
        }
        return jsonViewFactory.toJson();
    }

}
