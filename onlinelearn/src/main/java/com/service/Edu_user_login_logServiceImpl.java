package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_user_login_log;
import com.mapper.Edu_user_login_logDao;
@Service
public class Edu_user_login_logServiceImpl implements Edu_user_login_logService {
   @Autowired
   public Edu_user_login_logDao edu_user_login_log;
	@Override
	public List<Edu_user_login_log> listAll(Map map) {
		return edu_user_login_log.listAll(map);
	}

}
