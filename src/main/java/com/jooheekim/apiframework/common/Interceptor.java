package com.jooheekim.apiframework.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor{
	Logger logger = LogManager.getLogger(Interceptor.class);

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        // Controller 실행 전에 수행되는 메소드.
		 logger.info("===== preHandler START =====");
		 logger.info("Request URL : {}", request.getRequestURI());
	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        // Controller 실행 후 View가 랜더링 되기 전에 실행
	    	logger.info("===== preHandler END =====");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        // Controller 실행 후 View가 랜더링 된 후에 실행
	    	logger.info("===== after Completion =====");
	    }
}
