package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SysSubject;
import com.mapper.SysSubjectDao;

@Service
public class SysSubjectServiceImpl implements SysSubjectService{

	@Autowired
	private SysSubjectDao sysSubjectDao;
	@Override
	public SysSubject getById(int subjectId) {
		return sysSubjectDao.getById(subjectId);
	}

	@Override
	public void save(SysSubject subject) {
		sysSubjectDao.save(subject);
	}

	@Override
	public void delete(int subjectId) {
		sysSubjectDao.delete(subjectId);
	}

	@Override
	public void update(SysSubject sysSubject) {
		sysSubjectDao.update(sysSubject);
	}

	@Override
	public List<SysSubject> listAll(Map map) {
		return sysSubjectDao.listAll(map);
	}

	@Override
	public List<SysSubject> getChildNode(int subjectId) {
		return sysSubjectDao.getChildNode(subjectId);
	}

}
