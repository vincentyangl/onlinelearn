package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Questions_Comment;
import com.mapper.Edu_Questions_CommentDao;

@Service
public class Edu_Questions_CommentServiceImpl implements Edu_Questions_CommentService{

	@Autowired
	private Edu_Questions_CommentDao edu_Questions_CommentDao;
	
	@Override
	public List<Edu_Questions_Comment> listAll(Map map) {
		List<Edu_Questions_Comment> list=edu_Questions_CommentDao.listAll(map);
		return list;
	}

	@Override
	public void delete(int id) {
		edu_Questions_CommentDao.delete(id);
		
	}

	@Override
	public void save(Edu_Questions_Comment edu_Questions_Comment) {
		edu_Questions_CommentDao.save(edu_Questions_Comment);
		
	}

	@Override
	public void update(Edu_Questions_Comment edu_Questions_Comment) {
		edu_Questions_CommentDao.update(edu_Questions_Comment);
		
	}

	@Override
	public Edu_Questions_Comment getById(int id) {
		Edu_Questions_Comment edu_Questions_Comment=edu_Questions_CommentDao.getById(id);
		return edu_Questions_Comment;
	}

}