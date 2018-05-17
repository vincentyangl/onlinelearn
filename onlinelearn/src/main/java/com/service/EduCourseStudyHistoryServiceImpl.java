package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourse;
import com.bean.EduCourseStudyHistory;
import com.bean.EduKpoint;
import com.bean.Edu_User;
import com.mapper.EduCourseStudyHistoryDao;

@Service
public class EduCourseStudyHistoryServiceImpl implements EduCourseStudyHistoryService{

	@Autowired
	private EduCourseStudyHistoryDao eduCourseStudyHistoryDao;

	@Override
	public void save(EduCourseStudyHistory eduCourseStudyHistory) {
		eduCourseStudyHistoryDao.save(eduCourseStudyHistory);
	}

	@Override
	public void delete(int id) {
		eduCourseStudyHistoryDao.delete(id);
	}

	@Override
	public void update(EduCourseStudyHistory eduCourseStudyHistory) {
		eduCourseStudyHistoryDao.update(eduCourseStudyHistory);
	}

	@Override
	public List<EduCourseStudyHistory> listAll(Map map) {
		return eduCourseStudyHistoryDao.listAll(map);
	}

	@Override
	public EduCourseStudyHistory getById(int id) {
		return eduCourseStudyHistoryDao.getById(id);
	}

	@Override
	public void UpdateOrSave(EduCourseStudyHistory eduCourseStudyHistory, Edu_User user, EduCourse eduCourse,
			EduKpoint eduKpoint) {
		Map map = new HashMap<>();
		map.put("userId", user.getUserId());
		map.put("courseId", eduCourse.getCourse_id());
		map.put("kpointId", eduKpoint.getId());
		List<EduCourseStudyHistory> eduCourseStudyHistories = listAll(map);
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		Date updateTime =null;
		try {
			updateTime = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (eduCourseStudyHistories.size()==0) {
			eduCourseStudyHistory.setUser(user);
			eduCourseStudyHistory.setEduKpoint(eduKpoint);
			eduCourseStudyHistory.setEduCourse(eduCourse);
			eduCourseStudyHistory.setCourseName(eduCourse.getCourse_name());
			eduCourseStudyHistory.setKpointName(eduKpoint.getName());
			eduCourseStudyHistory.setDateBack(date+",");
			eduCourseStudyHistory.setUpdateTime(updateTime);
			save(eduCourseStudyHistory);
		}else {
			eduCourseStudyHistory = eduCourseStudyHistories.get(0);
			eduCourseStudyHistory.setUpdateTime(updateTime);
			eduCourseStudyHistory.setDateBack(eduCourseStudyHistory.getDateBack()+date+",");
			update(eduCourseStudyHistory);
		}
	}
	
}
