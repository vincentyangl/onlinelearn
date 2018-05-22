package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Questions;

public interface Edu_QuestionsDao {
	public List<Edu_Questions> listAll(Map map);
	public List<Edu_Questions> listAlls();
	public void delete(int id);
	public void save(Edu_Questions edu_Questions);
	public Edu_Questions getById(int id);
	public void update(Edu_Questions edu_Questions);
	public void updatedz(int id);
	public void saveRelation(Map map);
	public int getMaxId();
	public List<Edu_Questions> myQuestions(int userid);
	public void updatehfs(int id);
}
