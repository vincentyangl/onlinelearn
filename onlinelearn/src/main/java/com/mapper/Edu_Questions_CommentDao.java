package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Questions_Comment;

public interface Edu_Questions_CommentDao {
public List<Edu_Questions_Comment> listAll(Map map);
public void delete(int id);
public void save(Edu_Questions_Comment edu_Questions_Comment);
public void update(Edu_Questions_Comment edu_Questions_Comment);
public Edu_Questions_Comment getById(int id);
public List<Edu_Questions_Comment> listPL(int id);
public List<Edu_Questions_Comment> getByIdPD(int id);
public List<Edu_Questions_Comment> getByIdsx(int id);
public List<Edu_Questions_Comment> myQuestionsComment(int userId);
}
