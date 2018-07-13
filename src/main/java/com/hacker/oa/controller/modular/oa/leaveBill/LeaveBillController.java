package com.hacker.oa.controller.modular.oa;

import com.hacker.oa.entity.LeaveBill;
import com.hacker.oa.service.LeaveBillService;
import com.hacker.oa.util.FastJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


/**
 * 请假单处理
 * @author luxuebing
 * @date 2018/02/05下午2:53:01
 */
@Controller
@RequestMapping("/leaveBill")
public class LeaveBillController {

	public static Logger logger = LoggerFactory.getLogger(LeaveBillController.class);
	@Autowired
	private LeaveBillService service;

	/**
	 * 请假管理首页展示
	 * 
	 * @return
	 */
	@RequestMapping("/toHome")
	public String toHome() {
		return "leaveBill/list";
	}

	@ResponseBody
	@RequestMapping("/getLeaveBillList")
	public String getLeaveBillList() {
		List<LeaveBill> list = service.findLeaveBillList();
		return FastJsonUtil.serializeToJSON(list);
	}
	
	/**
	 * 添加请假申请页面
	 * 
	 * @return
	 */
	@RequestMapping("/toInput")
	public String toInput() {
		return "leaveBill/input";
	}

	/**
	 * 保存请假申请
	 * 
	 * @param bill
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveBill")
	public String saveBill(LeaveBill bill) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			service.saveLeaveBill(bill);
			map.put("success", true);
		} catch (Exception e) {
			logger.error("保存请假申请异常>>>" + e);
			e.printStackTrace();
		}
		return FastJsonUtil.serializeToJSON(map);
	}

	/**
	 * 删除请假申请
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBill")
	public String deleteBill(String id) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			service.deleteLeaveBillById(id);
			map.put("success", true);
		} catch (Exception e) {
			logger.error("删除请假申请异常>>>" + e);
			e.printStackTrace();
		}
		return FastJsonUtil.serializeToJSON(map);
	}
}
