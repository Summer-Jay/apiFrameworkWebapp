package com.jooheekim.apiframework.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.jooheekim.apiframework.requestUrl.RequestLoginUrl;
import com.jooheekim.apiframework.service.LoginService;
import com.jooheekim.utilLib.common.ResponseManager;

@Controller
public class LoginController implements RequestLoginUrl{
	Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
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
		logger.info("selectUserInfo service call------->");
		ResponseManager RESP_MANAGER = null;
		try {
			RESP_MANAGER = ResponseManager.getBuilderInstance(request);
			loginService.getTest(RESP_MANAGER);
		}catch(Exception e) {
			e.printStackTrace();
			RESP_MANAGER.setRESP_CODE("500");
		}
		return ResponseManager.getResult(RESP_MANAGER);
	}

}
