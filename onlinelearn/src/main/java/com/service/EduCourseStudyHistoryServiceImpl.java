package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourseStudyHistory;
import com.mapper.EduCourseStudyHistoryDao;

@Service
public class EduCourseStudyHistoryServiceImpl implements EduCourseStudyHistoryService{

	@Autowired
	private EduCourseStudyHistoryDao eduCourseStudyHistoryDao;

	@Override
	public void save(EduCourseStudyHistory eduCourseStudyHistory) {
		eduCourseStudyHistoryDao.save(eduCourseStudyHistory);
	}

	@Override
	public void delete(int id) {
		eduCourseStudyHistoryDao.delete(id);
	}

	@Override
	public void update(EduCourseStudyHistory eduCourseStudyHistory) {
		eduCourseStudyHistoryDao.update(eduCourseStudyHistory);
	}

	@Override
	public List<EduCourseStudyHistory> listAll(Map map) {
		return eduCourseStudyHistoryDao.listAll(map);
	}

	@Override
	public EduCourseStudyHistory getById(int id) {
		return eduCourseStudyHistoryDao.getById(id);
	}
	
}
