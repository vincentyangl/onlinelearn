package com.mapper;

import java.util.List;

import com.bean.Edu_User;

public interface Edu_UserDao {
public List<Edu_User> listAll();
public void delete(int id);
public void save(Edu_User edu_User);
public Edu_User getById(int id);
public void update(Edu_User edu_User);
}
