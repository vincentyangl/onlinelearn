package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_User;
import com.mapper.Edu_UserDao;
@Service
public class Edu_UserServiceImpl implements Edu_UserService{

	@Autowired
	private Edu_UserDao edu_UserDao;
	

	@Override
	public void delete(int id) {
		edu_UserDao.delete(id);
		
	}

	@Override
	public void save(Edu_User edu_User) {
		edu_UserDao.save(edu_User);
		
	}

	

	@Override
	public void update(Edu_User edu_User) {
		edu_UserDao.update(edu_User);
		
	}

	@Override
	public List<Edu_User> listAll(Map map) {
		return edu_UserDao.listAll(map);
	}

	@Override
	public Edu_User getById(int userId) {
		return edu_UserDao.getById(userId);
	}

	@Override
	public void toupdate(Edu_User edu_User) {
		edu_UserDao.toupdate(edu_User);
		
	}

	@Override
	public Edu_User getPwd(String email) {
		return edu_UserDao.getPwd(email);
	}

	@Override
	public List<Edu_User> listUser() {
		return edu_UserDao.listUser();
	}

	@Override
	public void updateMyinformation(Edu_User edu_User) {
		edu_UserDao.updateMyinformation(edu_User);
	}

	@Override
	public void updatepic(Edu_User edu_User) {
		edu_UserDao.updatepic(edu_User);
	}


}
