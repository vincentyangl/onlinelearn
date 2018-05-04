package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourse;
import com.mapper.EduCourseDao;

@Service
public class EduCourseServiceImpl implements EduCourseService{

	@Autowired
	private EduCourseDao eduCourseDao;
	@Override
	public void save(EduCourse eduCourse,String teacherIds[]) {
		 eduCourseDao.save(eduCourse);
		 int course_id = eduCourse.getCourse_id();
		 for (String teacher_id : teacherIds) {
			 Map map = new HashMap<>();
			 map.put("course_id", course_id);
			 map.put("teacher_id", teacher_id);
			eduCourseDao.saveCourseTeacher(map);
		}
	}

	@Override
	public void delete(int course_id) {
		eduCourseDao.delete(course_id);
	}

	@Override
	public void update(EduCourse eduCourse) {
		eduCourseDao.update(eduCourse);
	}

	@Override
	public List<EduCourse> listAll(Map map) {
		return eduCourseDao.listAll(map);
	}

	@Override
	public EduCourse getById(int course_id) {
		return eduCourseDao.getById(course_id);
	}

	
	
}
