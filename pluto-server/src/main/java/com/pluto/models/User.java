package com.pluto.models;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.continuation.Continuation;

public class User {
	private Continuation continuation;
	private String id;
	private String message;
	
	public boolean hasEvent(){
		return false;
	}
	
	public void setContinuation(Continuation continuation){
		this.continuation = continuation;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public Continuation getContinuation() {
		return continuation;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void sendEvent(HttpServletResponse response){
		
	}
}
