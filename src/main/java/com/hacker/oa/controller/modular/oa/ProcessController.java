package com.hacker.oa.controller.modular.oa;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.hacker.oa.common.JsonViewFactory;
import com.hacker.oa.service.WorkflowService;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.ActivitiTaskAlreadyClaimedException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 流程控制类
 * @author ZML
 *
 */
@Controller
@RequestMapping("/process")
public class ProcessController {
	private static final Logger logger = Logger.getLogger(ProcessController.class);

	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 部署流程
	 * @param modelId
	 * @return
	 */
	@RequestMapping(value = "deploy/{id}")
	@ResponseBody
	public String deploy(@PathVariable("id") String modelId) {
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
			jsonViewFactory.setCode(jsonViewFactory.ERRORCODE);
			jsonViewFactory.setSuccess(false);
			logger.error("根据模型部署流程失败：modelId={}" + modelId, e);
		}
		return jsonViewFactory.toJson();
	}

}
