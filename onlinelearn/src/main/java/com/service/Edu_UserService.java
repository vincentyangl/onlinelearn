package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_User;

public interface Edu_UserService {//学员管理
	
	public List<Edu_User> listAll(Map map);
	public void delete(int id);
	public void save(Edu_User edu_User);
	public Edu_User getById(int id);
	public void update(Edu_User edu_User);
}
