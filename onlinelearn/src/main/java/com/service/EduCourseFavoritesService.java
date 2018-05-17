package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourseFavorites;

public interface EduCourseFavoritesService {

	void save(EduCourseFavorites eduCourseFavorites);//添加收藏课程
	void delete(int id);//取消收藏
	List<EduCourseFavorites> listAll(Map map);
	EduCourseFavorites getById(int id);
}
