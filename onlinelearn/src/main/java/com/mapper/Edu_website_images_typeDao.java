package com.mapper;

import java.util.List;

import com.bean.Edu_website_images_type;
public interface Edu_website_images_typeDao { //图片类型管理
	
    public void save(Edu_website_images_type edu_website_images_type);
	public List<Edu_website_images_type> listAll();
	public void delete(int type_id);
	public void update(Edu_website_images_type edu_website_images_type);
	public Edu_website_images_type getById(int type_id);
}
