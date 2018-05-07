package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bean.SysRole;

public interface SysRoleDao {

	public void save(SysRole sysRole);
	public void delete(int roleId);
	public void update(SysRole sysRole);
	public List<SysRole> listAll();
	public SysRole getById(int roleId);
	public void deleteAllFunctionIdByRoleId(int roleId);
	public void addFunctionIdByRoleId(@Param("roleId") int roleId,@Param("functionId") int functionId);
	
}
