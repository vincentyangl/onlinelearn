package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourseFavorites;
import com.mapper.EduCourseFavoritesDao;

@Service
public class EduCourseFavoritesServiceImpl implements EduCourseFavoritesService{

	@Autowired
	private EduCourseFavoritesDao eduCourseFavoritesDao;

	@Override
	public void save(EduCourseFavorites eduCourseFavorites) {
		eduCourseFavoritesDao.save(eduCourseFavorites);
	}

	@Override
	public void delete(int id) {
		eduCourseFavoritesDao.delete(id);
	}

	@Override
	public List<EduCourseFavorites> listAll(Map map) {
		return eduCourseFavoritesDao.listAll(map);
	}

	@Override
	public EduCourseFavorites getById(int id) {
		return eduCourseFavoritesDao.getById(id);
	}
	
}
