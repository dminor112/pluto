package com.pluto.models;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.continuation.Continuation;

public class User {
	private Continuation continuation;
	
	public boolean hasEvent(){
		return false;
	}
	
	public void setContinuation(Continuation continuation){
		this.continuation = continuation;
	}
	
	public void sendEvent(HttpServletResponse response){
		
	}
}
