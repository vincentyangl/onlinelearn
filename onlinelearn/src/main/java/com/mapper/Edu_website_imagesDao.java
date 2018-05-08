package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_website_images;

public interface Edu_website_imagesDao {//图片管理
    
	 public void save(Edu_website_images edu_website_images);
	 public void delete(int imge_id);
	 public List<Edu_website_images> listAll(Map map);
	 public void update(Edu_website_images edu_website_images);
	 public Edu_website_images getById(int imge_id);
	 
}