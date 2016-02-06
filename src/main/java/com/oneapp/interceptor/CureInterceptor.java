package com.oneapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CureInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(CureInterceptor.class);

	public void afterCompletion(HttpServletRequest aRequest,
			HttpServletResponse aResponse, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		long startTime = (Long)aRequest.getAttribute("startTime");
		
		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;
		logger.info("Request URL::" + aRequest.getRequestURL().toString()
                + "::After Completion End Time=" + System.currentTimeMillis());
        logger.info("Request URL::" + aRequest.getRequestURL().toString()
                + "::After Completion Time Taken=" +executeTime);
        System.out.println("executeTime: "+executeTime);
	}
 
	public void postHandle(HttpServletRequest aRequest, HttpServletResponse aResponse,
			Object arg2, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Request URL::" + aRequest.getRequestURL().toString()
                + " Post Handle :: Current Time=" + System.currentTimeMillis());
	}

	public boolean preHandle(HttpServletRequest aRequest, HttpServletResponse aResponse,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		aRequest.setAttribute("startTime", startTime);
		logger.info("Request URL::" + aRequest.getRequestURL().toString()
                + ":: Pre Handle Start Time=" + startTime);
		System.out.println("startTime: "+startTime);
		return true;
	}

}
