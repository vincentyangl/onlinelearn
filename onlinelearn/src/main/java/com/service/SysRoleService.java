package com.service;

import java.util.List;

import com.bean.SysRole;

public interface SysRoleService {

	public void save(SysRole sysRole);
	public void delete(int roleId);
	public void update(SysRole sysRole);
	public List<SysRole> listAll();
	public SysRole getById(int roleId);
	
}
