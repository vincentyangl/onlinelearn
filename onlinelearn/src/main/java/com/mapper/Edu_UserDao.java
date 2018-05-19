package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_User;

public interface Edu_UserDao {//学员管理
	
public List<Edu_User> listAll(Map map);
public void delete(int userId);
public void save(Edu_User edu_User);
public Edu_User getById(int userId);
public void update(Edu_User edu_User);
public void toupdate(Edu_User edu_User);
public Edu_User getPwd(String email);
public List<Edu_User> listUser(); //
public void updateMyinformation(Edu_User edu_User);
public void updatepic(Edu_User edu_User);
}
