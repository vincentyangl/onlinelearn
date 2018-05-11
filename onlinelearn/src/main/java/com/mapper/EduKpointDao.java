package com.mapper;

import java.util.List;

import com.bean.EduKpoint;

public interface EduKpointDao {

	void save(EduKpoint eduKpoint);
	void update(EduKpoint eduKpoint);
	List<EduKpoint> listAll();
	EduKpoint getById(int id);
	List<EduKpoint> getByCourseId(int course_id);
	void delete(int id);
	List<EduKpoint> getchildKpoint(int pId);
}
