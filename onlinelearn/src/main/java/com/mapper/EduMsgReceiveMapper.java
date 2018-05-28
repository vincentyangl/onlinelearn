package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.EduMsgReceive;
import com.bean.EduMsgSystem;

public interface EduMsgReceiveMapper {

	List<EduMsgReceive> myMsg(int userId);
	List<EduMsgSystem> systemMsg();
	void deleteSystemMsg(int id);
	List<EduMsgReceive> queryUnReadLetter(Map map);
}
