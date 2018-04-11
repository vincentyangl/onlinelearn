package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.SysFunction;
import com.mapper.SysFunctionDao;

@Service
public class SysFunctionServiceImpl implements SysFunctionService{

	@Autowired
	private SysFunctionDao sysFunctionDao;

	@Override
	public List<SysFunction> listAll(Map map) {
		List<SysFunction> sysFunctions = sysFunctionDao.listAll(map);
		return sysFunctions;
	}

	@Override
	public List<SysFunction> getChildNode(int id) {
		List<SysFunction> sysFunctions = sysFunctionDao.getChildNode(id);
		return sysFunctions;
	}

	@Override
	public void save(SysFunction sysFunction) {
		sysFunctionDao.save(sysFunction);
	}

	@Override
	public void delete(int id) {
		sysFunctionDao.delete(id);
	}

	@Override
	public void update(SysFunction sysFunction) {
		sysFunctionDao.update(sysFunction);
	}

	@Override
	public List<SysFunction> getSysFunctionByRoleId(int roleId) {
		List<SysFunction> sysFunctions = sysFunctionDao.getSysFunctionByRoleId(roleId);
		return sysFunctions;
	}

	@Override
	public void updateName(SysFunction sysFunction) {
		sysFunctionDao.update(sysFunction);
	}
	
}
