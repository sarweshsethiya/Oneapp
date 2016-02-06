package com.oneapp.auth;

import java.beans.ConstructorProperties;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.oneapp.bean.UserDetails;

@RestController
@RequestMapping(value="/auth")
public class Authenticator {

	@RequestMapping(value="/authenticate" , method=RequestMethod.GET)
	@Consumes("application/json")
	public String getUserDetails(HttpServletRequest aRequest) throws IOException{
		BufferedReader reader = aRequest.getReader();
		Gson gson = new Gson();

		UserDetails lUserDetails = gson.fromJson(reader, UserDetails.class);
		System.out.println(lUserDetails);
		
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
		System.out.println("email"+aRequest.getParameter("emailid"));
		System.out.println("pwd"+aRequest.getParameter("password"));
		System.out.println("name"+aRequest.getParameter("name"));
		System.out.println("Hi");
		
		return "Hi Sarwesh voila!!";
	}
}
