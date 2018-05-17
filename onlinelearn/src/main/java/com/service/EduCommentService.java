package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduComment;

public interface EduCommentService {

	void save(EduComment eduComment);
	void delete(int commentId);
	List<EduComment> listAll(Map map);
	EduComment getById(int commentId);
	List<EduComment> getChildComment(int commentId);
	List<EduComment> getByOtherId(int otherId);
	void updatePraiseCount(int commentId);
	void updateReplyCount(int commentId);
}
