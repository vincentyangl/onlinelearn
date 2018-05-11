package com.service;

import java.util.List;


import com.bean.Edu_Questions_Tag;
import com.util.Ztree;


public interface Edu_Questions_TagService {
//	public List<Edu_Questions_Tag> listAll();
	public List<Ztree> listAll();
	public void save(Edu_Questions_Tag edu_Questions_Tag);
	public void delete(int questionsTagId);
	public void update(Edu_Questions_Tag edu_Questions_Tag);
	public Edu_Questions_Tag getById(int questionsTagId);
}