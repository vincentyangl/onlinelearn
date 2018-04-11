package com.mapper;

import java.util.List;

import com.bean.Edu_Questions;

public interface Edu_QuestionsDao {
public List<Edu_Questions> listAll();
public void delete(int id);
public void save(Edu_Questions edu_Questions);
public Edu_Questions getById(int id);
public void update(Edu_Questions edu_Questions);
}
