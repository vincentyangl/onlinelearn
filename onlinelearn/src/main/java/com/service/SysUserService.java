package com.service;

import java.util.List;
import java.util.Map;

import com.bean.SysUser;

public interface SysUserService {

	public List<SysUser> listAll(Map map);
	public void save(SysUser sysUser);
	public void delete(int userId);
	public void update(SysUser sysUser);
	
	public SysUser getById(int userId);
	
}
