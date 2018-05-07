package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.EduCourse;

public interface EduCourseDao {

	public int save(EduCourse eduCourse);
	public void delete(int course_id);
	public void update(EduCourse eduCourse);
	public List<EduCourse> listAll(Map map);
	public EduCourse getById(int course_id);
	public List<EduCourse> getCourseBySubjectId(int subjectId);
	public void saveCourseTeacher(Map map);
	public void deleteCourseTeacher(int course_id);
	public List<EduCourse> getByTeacherId(int id);
}
