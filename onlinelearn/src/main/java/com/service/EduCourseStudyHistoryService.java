package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourse;
import com.bean.EduCourseStudyHistory;
import com.bean.EduKpoint;
import com.bean.Edu_User;

public interface EduCourseStudyHistoryService {

	void save(EduCourseStudyHistory eduCourseStudyHistory);
	void delete(int id);
	void update(EduCourseStudyHistory eduCourseStudyHistory);
	List<EduCourseStudyHistory> listAll(Map map);
	EduCourseStudyHistory getById(int id);
	void UpdateOrSave(EduCourseStudyHistory eduCourseStudyHistory,Edu_User user,EduCourse eduCourse,EduKpoint eduKpoint);
}
