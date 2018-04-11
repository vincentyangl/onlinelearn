package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SysRole;
import com.mapper.SysRoleDao;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public void save(SysRole sysRole) {
		sysRoleDao.save(sysRole);
	}

	@Override
	public void delete(int roleId) {
		sysRoleDao.delete(roleId);
	}

	@Override
	public void update(SysRole sysRole) {
		sysRoleDao.update(sysRole);
	}

	@Override
	public List<SysRole> listAll() {
		List<SysRole> sysRoles = sysRoleDao.listAll();
		return sysRoles;
	}

	@Override
	public SysRole getById(int roleId) {
		SysRole sysRole = sysRoleDao.getById(roleId);
		return sysRole;
	}
	
}
