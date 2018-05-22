package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourseStudyHistory;
import com.bean.EduKpoint;
import com.bean.Edu_User;
import com.bean.Edu_user_login_log;
import com.mapper.StatisticalFigureDao;

@Service
public class StatisticalFigureServiceImpl implements StatisticalFigureService {

	@Autowired
	public StatisticalFigureDao statisticalFigureDao;

	@Override
	public List<Edu_User> listAll(Map map) {
		return statisticalFigureDao.listAll(map);
	}

	@Override
	public List<EduCourseStudyHistory> listStudyhistory(Map map) {
		return statisticalFigureDao.listStudyhistory(map);
	}

	@Override
	public List<Edu_user_login_log> listLoginAll(Map map) {
		return statisticalFigureDao.listLoginAll(map);
	}

	
	
}
