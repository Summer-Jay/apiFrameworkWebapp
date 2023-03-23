package com.jooheekim.apiframework.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerMapping;

import com.jooheekim.apiframework.coupler.RequestLoginCoupler;

@Controller
public class LoginController implements RequestLoginCoupler{

	@Override
	public ResponseEntity<Map<String, Object>> selectUserList(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String,Object>();

		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        resultMap.put("testData", "111111");
        resultMap.put("testData", "2222");
        resultMap.put("testData", "3333");
        resultMap.put("testData", "4444");
        resultMap.put("testData", "555");
		return new ResponseEntity<>(resultMap, header, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Map<String, Object>> selectUserInfo(HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String,Object>();

		paramMap = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		System.out.println("MEMBER_SEQ====>"+paramMap.get("MEMBER_SEQ"));
		System.out.println("VERSION_INFO====>"+paramMap.get("VERSION_INFO"));
		System.out.println(request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE).getClass().getName());

		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		System.out.println(request.getRequestURI());
		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		return new ResponseEntity<>(resultMap, header, HttpStatus.OK);

	}

}
