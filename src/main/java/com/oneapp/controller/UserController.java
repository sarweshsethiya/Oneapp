package com.oneapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.oneapp.bean.UserDetails;
import com.oneapp.delegate.UserDelegate;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserDelegate mUserDelegate;
	
	@RequestMapping(value="/createuser" , method=RequestMethod.POST)
	@Consumes("application/json")
	@Produces("application/json")
	public String getUserDetails(@Context HttpServletRequest aRequest) throws IOException{
		
		/*public String getUserDetails(@RequestParam("id") int id,
				@RequestParam("email") String emailId,
				@RequestParam("password") String password,
				@RequestParam("name") String name,
				@RequestParam("message") String message
				) throws IOException{*/
		Gson gson = new Gson();
		BufferedReader reader = aRequest.getReader();
		 Map messageObjMap = gson.fromJson(reader, Map.class);
		 //String type = messageObjMap.get("messageType").toString();

		 System.out.println("---"+messageObjMap);
		//UserDetails lUserDetails = gson.fromJson(reader, UserDetails.class);
		
		/*int id = Integer.parseInt(aRequest.getParameter("id"));
		String name =aRequest.getParameter("name");
		String password = aRequest.getParameter("password");
		String emailId = aRequest.getParameter("email");
		String message = aRequest.getParameter("message");*/
		 UserDetails lUserDetails =new UserDetails();
		 
		int id =  Integer.parseInt((String) messageObjMap.get("id"));
		String name =(String) messageObjMap.get("name");
		String password = (String) messageObjMap.get("password");
		String emailId = (String) messageObjMap.get("emailId");
		String message = (String) messageObjMap.get("message");
		 
		System.out.println(name+" "+emailId+" "+password+" "+message);
		lUserDetails.setId(id);
		lUserDetails.setEmailId(emailId);
		lUserDetails.setName(name);
		lUserDetails.setPassword(password);
		lUserDetails.setMessage(message);
		
		System.out.println(lUserDetails);
		
		Map m = mUserDelegate.saveUserDetails(lUserDetails);
		
		String json = gson.toJson(m);
		
		/*String email = aRequest.getParameter("emailId");
		System.out.println("email: "+ email);
		boolean valid = EmailValidator.getInstance().isValid(email);
		System.out.println("Request CONTEXT PATH"+aRequest.getContextPath());
		System.out.println("Request ORIGIN"+aRequest.getHeader("Origin"));
		System.out.println("Request CONTENT TYPE"+aRequest.getContentType());
		System.out.println("Request AUTH TYPE"+aRequest.getAuthType());
		System.out.println("Request PAATH INFO"+aRequest.getPathInfo());
		System.out.println("Request COTENT LENGTH"+aRequest.getContentLength());
		System.out.println("Request URI"+aRequest.getRequestURI());
		System.out.println("Request SERVLET CONTEXT"+aRequest.getServletContext());
		System.out.println("Request TO STRING"+aRequest.toString());
		System.out.println("name"+aRequest.getParameter("name"));
		System.out.println("pwd"+aRequest.getParameter("password"));
		System.out.println("Hi");*/
		
		return json;
	}
	
	
}
