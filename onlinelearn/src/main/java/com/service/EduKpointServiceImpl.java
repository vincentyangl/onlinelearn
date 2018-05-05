package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduKpoint;
import com.mapper.EduKpointDao;

@Service
public class EduKpointServiceImpl implements EduKpointService{

	@Autowired
	private EduKpointDao eduKpointDao;

	@Override
	public void save(EduKpoint eduKpoint) {
		eduKpointDao.save(eduKpoint);
	}

	@Override
	public void update(EduKpoint eduKpoint) {
		eduKpointDao.update(eduKpoint);
	}

	@Override
	public List<EduKpoint> listAll() {
		return eduKpointDao.listAll();
	}

	@Override
	public EduKpoint getById(int id) {
		return eduKpointDao.getById(id);
	}

	@Override
	public List<EduKpoint> getByCourseId(int course_id) {
		return eduKpointDao.getByCourseId(course_id);
	}

	@Override
	public void delete(int id) {
		eduKpointDao.delete(id);
	}
	
}
