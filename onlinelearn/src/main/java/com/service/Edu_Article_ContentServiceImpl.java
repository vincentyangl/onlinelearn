package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Article_Content;
import com.mapper.Edu_Article_ContentDao;
@Service
public class Edu_Article_ContentServiceImpl implements Edu_Article_ContentService{

	@Autowired
	private Edu_Article_ContentDao edu_Article_ContentDao;
	@Override
	public List<Edu_Article_Content> listAll() {
		List<Edu_Article_Content> list=edu_Article_ContentDao.listAll();
		return list;
	}

	@Override
	public void delete(int articleId) {
		edu_Article_ContentDao.delete(articleId);
		
	}

	@Override
	public void save(Edu_Article_Content edu_Article_Content) {
		edu_Article_ContentDao.save(edu_Article_Content);
		
	}

	@Override
	public void update(Edu_Article_Content edu_Article_Content) {
		edu_Article_ContentDao.update(edu_Article_Content);
		
	}

	@Override
	public Edu_Article_Content getById(int articleId) {
		Edu_Article_Content edu_Article_Content=edu_Article_ContentDao.getById(articleId);
		return edu_Article_Content;
	}

}
