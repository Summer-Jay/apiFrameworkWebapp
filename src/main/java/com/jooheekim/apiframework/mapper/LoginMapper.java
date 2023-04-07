package com.jooheekim.apiframework.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
	public List<Map<String,Object>> selectOneUser(Map<String,Object> paramMap);
}
