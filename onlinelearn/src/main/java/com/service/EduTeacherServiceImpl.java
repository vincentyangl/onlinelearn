package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduTeacher;
import com.mapper.EduTeacherDao;



@Service("eduTeacherService")
public class EduTeacherServiceImpl implements EduTeacherService{

	@Autowired
	private EduTeacherDao eduTeacherDao;
	@Override
	public void save(EduTeacher eduTeacher) {
		eduTeacherDao.save(eduTeacher);
	}

	@Override
	public List<EduTeacher> listAll(Map map) {
		return eduTeacherDao.listAll(map);
	}

	@Override
	public EduTeacher getById(int id) {
		return eduTeacherDao.getById(id);
	}

	@Override
	public void delete(int id) {
		eduTeacherDao.delete(id);
	}

	@Override
	public void update(EduTeacher eduTeacher) {
		eduTeacherDao.update(eduTeacher);
	}

	public List<EduTeacher> getTeacherBySubjectId(int subjectId) {
		return eduTeacherDao.getTeacherBySubjectId(subjectId);
	}
}
