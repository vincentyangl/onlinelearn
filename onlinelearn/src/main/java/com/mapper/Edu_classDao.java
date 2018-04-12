package com.mapper;

import java.util.List;

import com.bean.Edu_class;

public interface Edu_classDao { //班级

	public Edu_class getById(int id);
	public List<Edu_class> listAll();

}
