package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.EduTeacher;

public interface EduTeacherDao {

	public void save(EduTeacher eduTeacher);
	public List<EduTeacher> listAll(Map map);
	public EduTeacher getById(int id);
	public void delete(int id);
	public void update(EduTeacher eduTeacher);
	public List<EduTeacher> listBySid(int subjectId);
	public List<EduTeacher> getTeacherBySubjectId(int subjectId);
	public List<EduTeacher> getTeacherByCourseId(int course_id);
	public EduTeacher getKpointById(int id);
}
