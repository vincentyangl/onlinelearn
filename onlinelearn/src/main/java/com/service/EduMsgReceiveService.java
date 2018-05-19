package com.service;

import java.util.List;

import com.bean.EduMsgReceive;
import com.bean.EduMsgSystem;

public interface EduMsgReceiveService {

	List<EduMsgReceive> myMsg(int userId);
	List<EduMsgSystem> systemMsg();
	void deleteSystemMsg(int id);
}
