package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Article;
import com.bean.Edu_Article_Content;
import com.mapper.Edu_ArticleDao;
import com.mapper.Edu_Article_ContentDao;

@Service
public class Edu_ArticleServiceImpl implements Edu_ArticleService{

	@Autowired
	private Edu_ArticleDao edu_ArticleDao;
	@Autowired
	private Edu_Article_ContentDao edu_Article_ContentDao;
	@Override
	public List<Edu_Article> listAll(Map map) {
		List<Edu_Article> list=edu_ArticleDao.listAll(map);
		return list;
	}

	@Override
	public void delete(int articleId) {
		edu_ArticleDao.delete(articleId);
		
	}

	@Override
	public void save(Edu_Article edu_Article) {
		edu_ArticleDao.save(edu_Article);
		
	}

	@Override
	public void update(Edu_Article edu_Article) {
		
		edu_ArticleDao.update(edu_Article);
		
	}

	@Override
	public Edu_Article getById(int articleId) {
		Edu_Article edu_Article=edu_ArticleDao.getById(articleId);
		return edu_Article;
	}

	@Override
	public void updateContent(Edu_Article map) {
		edu_ArticleDao.updateContent(map);
	}

	@Override
	public void saveContent(Edu_Article map) {
		edu_ArticleDao.saveContent(map);
		
	}

}
