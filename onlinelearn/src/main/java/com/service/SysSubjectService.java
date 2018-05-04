package com.service;

import java.util.List;
import java.util.Map;

import com.bean.SysSubject;

public interface SysSubjectService {

	public SysSubject getById(int subjectId);
	public List<SysSubject> listDad();
	public void save(SysSubject subject);
	public void delete(int subjectId);
	public void update(SysSubject sysSubject);
	public List<SysSubject> listAll(Map map);
	public List<SysSubject> getChildNode(int subjectId);
}
