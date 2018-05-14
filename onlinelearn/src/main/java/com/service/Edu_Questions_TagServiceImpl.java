package com.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Questions_Tag;
import com.mapper.Edu_Questions_TagDao;
import com.util.Ztree;

@Service
public class Edu_Questions_TagServiceImpl implements Edu_Questions_TagService{

	@Autowired
	private Edu_Questions_TagDao edu_Questions_TagDao;
//	@Override
//	public List<Edu_Questions_Tag> listAll() {
//		List<Edu_Questions_Tag> list=edu_Questions_TagDao.listAll();
//		return list;
//	}

	@Override
	public void save(Edu_Questions_Tag edu_Questions_Tag) {
		edu_Questions_TagDao.save(edu_Questions_Tag);
	}

	@Override
	public void delete(int questionsTagId) {
		edu_Questions_TagDao.delete(questionsTagId);
		
	}

	@Override
	public void update(Edu_Questions_Tag edu_Questions_Tag) {
		edu_Questions_TagDao.update(edu_Questions_Tag);
		
	}

	@Override
	public Edu_Questions_Tag getById(int questionsTagId) {
		Edu_Questions_Tag edu_Questions_Tag=edu_Questions_TagDao.getById(questionsTagId);
		return edu_Questions_Tag;
	}

	@Override
	public List<Ztree> listAll() {
		List<Edu_Questions_Tag> list=edu_Questions_TagDao.listAll();
		List<Ztree> notes=new ArrayList<Ztree>();
		for (int i = 0; i < list.size(); i++) {
			 Edu_Questions_Tag edu_Questions_Tag=list.get(i);
			 Ztree ztreeNode=new Ztree();
			 ztreeNode.setId(edu_Questions_Tag.getQuestionsTagId());
			 ztreeNode.setName(edu_Questions_Tag.getQuestionsTagName());
			 ztreeNode.setpId(edu_Questions_Tag.getParentId());
			 notes.add(ztreeNode);
		}
		return notes;
	}

}
