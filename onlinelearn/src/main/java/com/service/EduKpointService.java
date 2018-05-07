package com.service;

import java.util.List;

import com.bean.EduKpoint;

public interface EduKpointService {

	void save(EduKpoint eduKpoint);
	void update(EduKpoint eduKpoint);
	List<EduKpoint> listAll();
	EduKpoint getById(int id);
	List<EduKpoint> getByCourseId(int course_id);
	void delete(int id);
	
}
