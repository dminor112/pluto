package com.pluto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.continuation.Continuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluto.constants.WebConstant;
import com.pluto.models.User;
import com.pluto.service.UserService;

@Controller
public class PushController extends BaseController{
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/push")
	public void doPush(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("uid");
		String message = request.getParameter("msg");
		int status = 200;
		String data = null;
		System.out.println("---------push, 1, " + userId + ", " + message);
		User user = userService.getUser(userId);
		if(userId == null || message == null || user == null){
			data = "params error.";
			status = WebConstant.PARAM_ERROR;
		}else{
			user.setMessage(message);
			Continuation continuation = user.getContinuation();
			continuation.resume();
		}
		this.sendResponse(response, status, data);
	}
}
