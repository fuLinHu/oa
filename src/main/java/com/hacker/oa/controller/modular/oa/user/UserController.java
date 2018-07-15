package com.hacker.oa.controller.modular.oa.user;

import javax.servlet.http.HttpSession;

import com.hacker.oa.entity.User;
import com.hacker.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author luxuebing
 * @date 2018/02/09上午11:12:20
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	/**
	 * 登录
	 * @param name
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String name,HttpSession session) {
		User user = userService.login(name);
		if(null != user) {
			session.setAttribute("user",user);
			return "main";
		}
		return null;
	}
	
	/**
	 * 顶部标题
	 * @return
	 */
	@RequestMapping("/toTop")
	public String toTop() {
		return "top";
	}
	
	/**
	 * 左侧菜单
	 * @return
	 */
	@RequestMapping("/toLeft")
	public String toLeft() {
		return "left";
	}
	
	/**
	 * 主页展示
	 * @return
	 */
	@RequestMapping("/toWelcome")
	public String toWelcome() {
		return "welcome";
	}
	
	/**
	 * 登出系统
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "login";
	}
	
	/**
	 * test
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getParams",consumes="application/json",method = RequestMethod.POST)
	public String getParams(@RequestBody(required=false) User user){
		System.out.println("id=" + user.getId() + ",name=" + user.getName() + ",password=" + user.getPassword());
		return null;
	}
}
