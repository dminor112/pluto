package com.pluto.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;

import com.pluto.models.User;

public class PollServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response){
    	System.out.println("------====1");
    	User u = new User();
        if (!u.hasEvent())
        {
            Continuation continuation = ContinuationSupport.getContinuation(request);
            u.setContinuation(continuation);
            System.out.println("------====2");
            continuation.suspend(response);
        }
        System.out.println("------====2");
        u.setContinuation(null);
        u.sendEvent(response);
        System.out.println("------====4");
    }
}
