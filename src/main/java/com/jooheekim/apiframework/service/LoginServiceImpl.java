package com.jooheekim.apiframework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooheekim.apiframework.mapper.LoginMapper;
import com.jooheekim.utilLib.common.CommonUtil;
import com.jooheekim.utilLib.common.ParameterUtil;
import com.jooheekim.utilLib.common.ResponseManager;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{
	Logger logger = LogManager.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public void getTest(ResponseManager respManager) throws Exception {
		logger.info("call getTest service ------> {} " +ParameterUtil.getReqUrlParam(respManager.getREQ_DATA()));
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String MEMBER_SEQ = CommonUtil.getString(ParameterUtil.getReqUrlParam(respManager.getREQ_DATA()).get("MEMBER_SEQ"));
			String VERSION_INFO = CommonUtil.getString(ParameterUtil.getReqUrlParam(respManager.getREQ_DATA()).get("VERSION_INFO"));
			String PAGE_NUM = CommonUtil.getString(ParameterUtil.getReqUrlParam(respManager.getREQ_DATA()).get("pagenum"));
			String QUERYPARAM_TEST = CommonUtil.getString(ParameterUtil.getReqUrlParam(respManager.getREQ_DATA()).get("queryparamtest"));
			
			System.out.println("MEMBER_SEQ::"+MEMBER_SEQ);
			System.out.println("VERSION_INFO::"+VERSION_INFO);
			System.out.println("PAGE_NUM::"+PAGE_NUM);
			System.out.println("QUERYPARAM_TEST::"+QUERYPARAM_TEST);
			Map<String, Object> paramMap = new HashMap<String,Object>();
			
			List<Map<String, Object>> memberList = new ArrayList<Map<String,Object>>();
			memberList = loginMapper.selectOneUser(paramMap);
			
			resultMap.put("MEMBER_LIST", memberList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			respManager.setRESULT_BODY(resultMap);
		}
	}

}
