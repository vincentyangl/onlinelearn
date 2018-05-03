package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SysSubject;
import com.mapper.SysSubjectDao;

@Service
public class SysSubjectServiceImpl implements SysSubjectService{

	@Autowired
	private SysSubjectDao sysSubjectDao;
	@Override
	public List<SysSubject> listAll() {
		return sysSubjectDao.listAll();
	}
	@Override
	public SysSubject getById(int subjectId) {
		return sysSubjectDao.getById(subjectId);
	}
	@Override
	public List<SysSubject> listDad() {
		return sysSubjectDao.listDad();
	}

}
