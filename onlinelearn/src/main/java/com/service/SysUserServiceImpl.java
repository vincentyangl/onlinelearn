package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SysUser;
import com.mapper.SysUserDao;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public List<SysUser> listAll(Map map) {
		List<SysUser> sysUsers = sysUserDao.listAll(map);
		return sysUsers;
	}

	@Override
	public void save(SysUser sysUser) {
		sysUserDao.save(sysUser);
	}

	@Override
	public void delete(int userId) {
		sysUserDao.delete(userId);
	}

	@Override
	public void update(SysUser sysUser) {
		sysUserDao.update(sysUser);
	}

	@Override
	public SysUser getById(int userId) {
		return sysUserDao.getById(userId);
	}

	@Override
	public void updatePwd(SysUser sysUser) {
		sysUserDao.updatePwd(sysUser);
	}
	
}
