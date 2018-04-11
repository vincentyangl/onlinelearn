package com.mapper;

import java.util.List;

import com.bean.SysRole;

public interface SysRoleDao {

	public void save(SysRole sysRole);
	public void delete(int roleId);
	public void update(SysRole sysRole);
	public List<SysRole> listAll();
	public SysRole getById(int roleId);
	
}
