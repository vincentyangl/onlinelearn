package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Questions;

public interface Edu_QuestionsService {
	public List<Edu_Questions> listAll(Map map);
	public void delete(int id);
	public void save(Edu_Questions edu_Questions);
	public Edu_Questions getById(int id);
	public void update(Edu_Questions edu_Questions);
}
