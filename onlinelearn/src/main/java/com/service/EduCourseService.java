package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourse;

public interface EduCourseService {

	public void save(EduCourse eduCourse);
	public void delete(int course_id);
	public void update(EduCourse eduCourse);
	public List<EduCourse> listAll(Map map);
	public EduCourse getById(int course_id);
	
}
