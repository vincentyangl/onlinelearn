package com.service;

import java.util.List;

import com.bean.CommentPraise;

public interface CommentPraiseService {

	List<CommentPraise> listAll(CommentPraise praise);
	void save(CommentPraise praise);
	
}
