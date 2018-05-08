package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_website_images_type;
import com.mapper.Edu_website_images_typeDao;
@Service
public class Edu_website_images_typeServiceImpl implements Edu_website_images_typeService {
  @Autowired
  private Edu_website_images_typeDao edu_website_images_typeDao;
	@Override
	public void save(Edu_website_images_type edu_website_images_type) {
		edu_website_images_typeDao.save(edu_website_images_type);
	}

	@Override
	public List<Edu_website_images_type> listAll() {
		return edu_website_images_typeDao.listAll();
	}

	@Override
	public void delete(int type_id) {
          edu_website_images_typeDao.delete(type_id);
	}

	@Override
	public void update(Edu_website_images_type edu_website_images_type) {
         edu_website_images_typeDao.update(edu_website_images_type);
	}

	@Override
	public Edu_website_images_type getById(int type_id) {
		return edu_website_images_typeDao.getById(type_id);
	}

}
