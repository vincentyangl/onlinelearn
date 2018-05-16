package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourseStudyHistory;

public interface EduCourseStudyHistoryService {

	void save(EduCourseStudyHistory eduCourseStudyHistory);
	void delete(int id);
	void update(EduCourseStudyHistory eduCourseStudyHistory);
	List<EduCourseStudyHistory> listAll(Map map);
	EduCourseStudyHistory getById(int id);
}
