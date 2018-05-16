package com.mapper;

import java.util.List;

import com.bean.CommentPraise;

public interface CommentPraiseDao {

	List<CommentPraise> listAll(CommentPraise praise);
	void save(CommentPraise praise);
}
