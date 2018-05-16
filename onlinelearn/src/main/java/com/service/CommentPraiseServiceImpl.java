package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CommentPraise;
import com.mapper.CommentPraiseDao;

@Service
public class CommentPraiseServiceImpl implements CommentPraiseService{

	@Autowired
	private CommentPraiseDao commentPraiseDao;

	@Override
	public List<CommentPraise> listAll(CommentPraise praise) {
		return commentPraiseDao.listAll(praise);
	}

	@Override
	public void save(CommentPraise praise) {
		commentPraiseDao.save(praise);
	}
	
}
