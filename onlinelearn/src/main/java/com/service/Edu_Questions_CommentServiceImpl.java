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

	@Override
	public List<Edu_Questions_Comment> listPL(int id) {
		List<Edu_Questions_Comment> listpl=edu_Questions_CommentDao.listPL(id);
		return listpl;
	}

	@Override
	public List<Edu_Questions_Comment> getByIdPD(int id) {
		List<Edu_Questions_Comment> listpd=edu_Questions_CommentDao.getByIdPD(id);
		return listpd;
	}

	@Override
	public List<Edu_Questions_Comment> getByIdsx(int id) {
		List<Edu_Questions_Comment> listsx=edu_Questions_CommentDao.getByIdsx(id);
		return listsx;
	}

	@Override
	public void updatedzc(int id) {
		edu_Questions_CommentDao.updatedzc(id);
	}

	@Override
	public List<Edu_Questions_Comment> getById2(int id) {
		List<Edu_Questions_Comment> edu_Questions_Comments=edu_Questions_CommentDao.getById2(id);
		return edu_Questions_Comments;
	}

	@Override
	public List<Edu_Questions_Comment> getById3(int id) {
		List<Edu_Questions_Comment> edu_Questions_Comments=edu_Questions_CommentDao.getById3(id);
		return edu_Questions_Comments;
	}

	@Override
	public List<Edu_Questions_Comment> getListById(int commentId) {
		List<Edu_Questions_Comment> list=edu_Questions_CommentDao.getListById(commentId);
		return list;
	}
	
	@Override
	public List<Edu_Questions_Comment> myQuestionsComment(int userId) {
		return edu_Questions_CommentDao.myQuestionsComment(userId);
	}

}
