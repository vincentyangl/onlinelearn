package com.mapper;

import java.util.List;

import com.bean.EduTeacher;

public interface EduTeacherDao {

	public void save(EduTeacher eduTeacher);
	public List<EduTeacher> listAll();
	public EduTeacher getById(int id);
	public void delete(int id);
	public void update(EduTeacher eduTeacher);
}
