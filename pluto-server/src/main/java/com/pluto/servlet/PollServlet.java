package com.pluto.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;

import com.pluto.models.User;

public class PollServlet extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        postMessage(request, response);
    }
    
    private void postMessage(HttpServletRequest request, HttpServletResponse response)
    {
        User u = new User();
        if (!u.hasEvent())
        {
            Continuation continuation = ContinuationSupport.getContinuation(request);
            u.setContinuation(continuation);
            continuation.suspend(response);
        }
        u.setContinuation(null);
        u.sendEvent(response);
    }
}
