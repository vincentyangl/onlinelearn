package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourseFavorites;

public interface EduCourseFavoritesService {

	void save(EduCourseFavorites eduCourseFavorites);//����ղؿγ�
	void delete(int id);//ȡ���ղ�
	List<EduCourseFavorites> listAll(Map map);
	EduCourseFavorites getById(int id);
}
