package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduMsgReceive;
import com.bean.EduMsgSystem;
import com.mapper.EduMsgReceiveMapper;
@Service
public class EduMsgReceiveServiceImpl implements EduMsgReceiveService{

	@Autowired
	private EduMsgReceiveMapper mapper;
	
	public List<EduMsgReceive> myMsg(int userId) {
		
		return mapper.myMsg(userId);
	}

	@Override
	public List<EduMsgSystem> systemMsg() {
		return mapper.systemMsg();
	}

	@Override
	public void deleteSystemMsg(int id) {
		mapper.deleteSystemMsg(id);
	}



}
