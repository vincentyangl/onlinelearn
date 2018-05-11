package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Article;

public interface Edu_ArticleService {
	public List<Edu_Article> listAll(Map map);
	public void delete(int articleId);
	public void save(Edu_Article edu_Article);
	public void update(Edu_Article edu_Article);
	public Edu_Article getById(int articleId);
	public void updateContent(Edu_Article map);
	public void saveContent(Edu_Article map);
}
