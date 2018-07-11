package com.hacker.oa.util;

import javax.servlet.http.HttpServletRequest;

import com.hacker.oa.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * session工具类
 * @author luxuebing
 * @date 2018/02/06下午9:59:52
 */
public class SessionUtil {
	
	private static final String GLOBLE_SESSION_KEY = "user";
	
	public static User get() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return (User) request.getSession().getAttribute(GLOBLE_SESSION_KEY);
	}
	
	public static void set(String username) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		if(username != null) {
			request.getSession().setAttribute(GLOBLE_SESSION_KEY, username);
		}else{
			request.getSession().removeAttribute(GLOBLE_SESSION_KEY);
		}
	}
}
