package com.service;

import java.util.List;
import java.util.Map;

import com.bean.SysFunction;

public interface SysFunctionService {

	public List<SysFunction> listAll(Map map);
	public List<SysFunction> getChildNode(int id);
	public void save(SysFunction sysFunction);
	public void delete(int id);
	public void update(SysFunction sysFunction);
	public List<SysFunction> getSysFunctionByRoleId(int roleId);
	public void updateName(SysFunction sysFunction);
	
}
