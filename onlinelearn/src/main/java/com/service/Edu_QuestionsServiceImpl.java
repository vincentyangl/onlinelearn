package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Questions;
import com.mapper.Edu_QuestionsDao;
import com.mapper.Edu_UserDao;
@Service
public class Edu_QuestionsServiceImpl implements Edu_QuestionsService{
	@Autowired
	private Edu_QuestionsDao edu_QuestionsDao;
	@Autowired
	private Edu_UserDao edu_UserDao;
	
	@Override
	public List<Edu_Questions> listAll(Map map) {
		List<Edu_Questions> list=edu_QuestionsDao.listAll(map);
		return list;
	}

	@Override
	public void delete(int id) {
		edu_QuestionsDao.delete(id);
		
	}

	@Override
	public void save(Edu_Questions edu_Questions) {
		edu_QuestionsDao.save(edu_Questions);
		
	}

	@Override
	public Edu_Questions getById(int id) {
		Edu_Questions edu_Questions=edu_QuestionsDao.getById(id);
		return edu_Questions;
	}

	@Override
	public void update(Edu_Questions edu_Questions) {
		
		edu_QuestionsDao.update(edu_Questions);
//		edu_UserDao.update(edu_User);
	}

}
