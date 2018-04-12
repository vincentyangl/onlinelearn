package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_class;
import com.mapper.Edu_classDao;
@Service
public class Edu_classServiceImpl implements Edu_classService {
   @Autowired
   private Edu_classDao edu_classDao;

@Override
public Edu_class getById(int id) {
	//Edu_class edu_class=edu_classService.getById(id);
	return edu_classDao.getById(id);
}

@Override
public List<Edu_class> listAll() {
//	List<Edu_class>list=edu_classService.listAll();
	return edu_classDao.listAll();
}


	

}
