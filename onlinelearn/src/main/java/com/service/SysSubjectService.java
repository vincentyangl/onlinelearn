package com.service;

import java.util.List;

import com.bean.SysSubject;

public interface SysSubjectService {

	public List<SysSubject> listAll();
	public SysSubject getById(int subjectId);
	public List<SysSubject> listDad();
}
