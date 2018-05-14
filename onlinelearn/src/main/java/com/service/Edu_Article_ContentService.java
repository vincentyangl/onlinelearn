package com.service;

import java.util.List;

import com.bean.Edu_Article_Content;

public interface Edu_Article_ContentService {
	public List<Edu_Article_Content> listAll();
	public void delete(int articleId);
	public void save(Edu_Article_Content edu_Article_Content);
	public void update(Edu_Article_Content edu_Article_Content);
	public Edu_Article_Content getById(int articleId);
}
