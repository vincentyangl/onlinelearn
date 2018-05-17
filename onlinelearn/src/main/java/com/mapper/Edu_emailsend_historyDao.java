package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_User;
import com.bean.Edu_emailsend_history;

public interface Edu_emailsend_historyDao {//邮件管理
   
	public void save(Edu_emailsend_history edu_emailsend_history);
	public void timingsave(Edu_emailsend_history edu_emailsend_history);
	public List<Edu_emailsend_history> listAll(Map map);
	public void delete(int id);
	public Edu_emailsend_history getById(int id);
	
	public Edu_User getByEmail(String userName);
}
