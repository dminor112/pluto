package com.pluto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pluto.models.User;
import com.pluto.service.UserService;

@Controller
public class PollController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/poll", method = RequestMethod.GET)
	public void doPoll(HttpServletRequest request, HttpServletResponse response){
    	logger.error("------====1");
    	String userId = request.getParameter("uid");
    	System.out.println("------====xxx" + userId);
    	if(userId == null){
    		this.printNoCache(response, "not userid...");
    		return;
    	}
    	User user = userService.getUser(userId);
    	if(user == null){
    		user = new User();
    		user.setId(userId);
    		userService.addUser(user);
    	}
    	String message = user.getMessage();
        if (message == null){
            Continuation continuation = ContinuationSupport.getContinuation(request);
            user.setContinuation(continuation);
            System.out.println("------====2");
            continuation.setTimeout(10000);
            continuation.suspend(response);
        }else{
        	this.sendResponse(response, 200, message);
        }
        System.out.println("------====2");
//        user.setContinuation(null);
        System.out.println("------====4");
	}
}
