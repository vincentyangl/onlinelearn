package com.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.WebEduMsgRereivingDao;

@Service
public class WebEduMsgReceivingServiceImpl implements WebEduMsgReceivingService{

	@Autowired
	private WebEduMsgRereivingDao webEduMsgRereivingDao;

	@Override
	public int queryUnReadLetter(Map map) {
		return webEduMsgRereivingDao.queryUnReadLetter(map);
	}
	
}
