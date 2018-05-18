package com.mapper;

import java.util.List;

import com.bean.EduMsgReceive;
import com.bean.EduMsgSystem;

public interface EduMsgReceiveMapper {

	List<EduMsgReceive> myMsg(int userId);
	List<EduMsgSystem> systemMsg();
	void deleteSystemMsg(int id);
}
