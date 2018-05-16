package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_website_images;
import com.mapper.Edu_website_imagesDao;
@Service
public class Edu_website_imagesServiceImpl implements Edu_website_imagesService {
    @Autowired
    private Edu_website_imagesDao edu_website_imagesDao;
    
	@Override
	public void save(Edu_website_images edu_website_images) {
		edu_website_imagesDao.save(edu_website_images);
	}

	@Override
	public void delete(int imge_id) {
            edu_website_imagesDao.delete(imge_id);
	}

	@Override
	public List<Edu_website_images> listAll(Map map) {
		return edu_website_imagesDao.listAll(map);
	}

	@Override
	public void update(Edu_website_images edu_website_images) {
       edu_website_imagesDao.update(edu_website_images);
	}

	@Override
	public Edu_website_images getById(int imge_id) {
		return edu_website_imagesDao.getById(imge_id);
	}

	
	@Override
	public List<Edu_website_images> weblistAll() {
		return edu_website_imagesDao.weblistAll();
	}

	@Override
	public void showUpdate(Edu_website_images edu_website_images) {
              edu_website_imagesDao.showUpdate(edu_website_images);		
	}

}
