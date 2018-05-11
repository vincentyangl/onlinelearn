package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Questions_Comment;

public interface Edu_Questions_CommentService {
	public List<Edu_Questions_Comment> listAll(Map map);
	public void delete(int id);
	public void save(Edu_Questions_Comment edu_Questions_Comment);
	public void update(Edu_Questions_Comment edu_Questions_Comment);
	public Edu_Questions_Comment getById(int id);
}
