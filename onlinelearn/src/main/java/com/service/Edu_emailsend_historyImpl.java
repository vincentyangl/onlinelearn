package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_emailsend_history;
import com.mapper.Edu_emailsend_historyDao;
@Service
public class Edu_emailsend_historyImpl implements Edu_emailsend_historyService {
 @Autowired
    private Edu_emailsend_historyDao edu_emailsend_historyDao;
	@Override
	public void save(Edu_emailsend_history edu_emailsend_history) {
		edu_emailsend_historyDao.save(edu_emailsend_history);
	}

	@Override
	public List<Edu_emailsend_history> listAll(Map map) {
		return edu_emailsend_historyDao.listAll(map);
	}

	@Override
	public void delete(int id) {
      edu_emailsend_historyDao.delete(id);
	}

	@Override
	public Edu_emailsend_history getById(int id) {
		return edu_emailsend_historyDao.getById(id);
	}

}
