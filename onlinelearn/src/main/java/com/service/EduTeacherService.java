package com.service;

import java.util.List;

import com.bean.EduTeacher;

public interface EduTeacherService {

	public void save(EduTeacher eduTeacher);
	public List<EduTeacher> listAll();
	public EduTeacher getById(int id);
	public void delete(int id);
	public void update(EduTeacher eduTeacher);
	public List<EduTeacher> getTeacherBySubjectId(int subjectId);
}
