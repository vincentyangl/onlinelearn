package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduComment;
import com.mapper.EduCommentDao;

@Service
public class EduCommentServiceImpl implements EduCommentService{

	@Autowired
	private EduCommentDao eduCommentDao;

	@Override
	public void save(EduComment eduComment) {
		eduCommentDao.save(eduComment);
	}

	@Override
	public void delete(int commentId) {
		eduCommentDao.delete(commentId);
	}

	@Override
	public List<EduComment> listAll(Map map) {
		return eduCommentDao.listAll(map);
	}

	@Override
	public EduComment getById(int commentId) {
		return eduCommentDao.getById(commentId);
	}

	@Override
	public List<EduComment> getChildComment(int commentId) {
		return eduCommentDao.getChildComment(commentId);
	}

	@Override
	public void updatePraiseCount(int commentId) {
		eduCommentDao.updatePraiseCount(commentId);
	}

	@Override
	public void updateReplyCount(int commentId) {
		eduCommentDao.updateReplyCount(commentId);
	}

	@Override
	public List<EduComment> getByOtherId(int otherId) {
		List<EduComment> list=eduCommentDao.getByOtherId(otherId);
		return list;
	}
}
