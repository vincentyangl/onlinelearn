package com.service;



import java.util.List;

import com.bean.Edu_class;

public interface Edu_classService {//班级
	
	public Edu_class getById(int id);
	public List<Edu_class> listAll();


}
