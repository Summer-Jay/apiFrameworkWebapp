package com.jooheekim.apiframework.coupler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/v1.0/login")
public interface RequestLoginCoupler {

	@RequestMapping(value="/checkUserList", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> selectUserList(HttpServletRequest request);
	
	@RequestMapping(value="/member/{MEMBER_SEQ}/version/{VERSION_INFO}", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> selectUserInfo(HttpServletRequest request);
}

