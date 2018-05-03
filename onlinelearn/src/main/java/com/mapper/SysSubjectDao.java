package com.mapper;

import java.util.List;

import com.bean.SysSubject;

public interface SysSubjectDao {

	public List<SysSubject> listAll();
	public SysSubject getById(int subjectId);
	public List<SysSubject> listDad();
}
