package com.jooheekim.apiframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jooheekim.utilLib.common.CommonUtil;
import com.jooheekim.utilLib.common.Constants;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String testHome() {
		System.out.println("커스텀라이브러리 테스트===>"+CommonUtil.getString(Constants.getProperties("service.domain")));

		return "test";
	}

}
