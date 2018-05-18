package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourseFavorites;
import com.bean.Edu_User;
import com.mapper.EduCourseFavoritesDao;
import com.util.ObjectUtils;

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

	@Override
	public boolean getIsFavorites(int course_id, Edu_User user) {
		boolean isFavorites = false;
		if (ObjectUtils.isNotNull(user)) {
			Map map = new HashMap<>();
			map.put("courseId", course_id);
			map.put("userId", user.getUserId());
			List<EduCourseFavorites> favoriteList = listAll(map);
			if (favoriteList.size()>0) {
				isFavorites=true;
			}
		}
		return isFavorites;
	}
	
}
