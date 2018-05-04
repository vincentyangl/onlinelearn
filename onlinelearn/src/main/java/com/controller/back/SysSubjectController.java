package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.SysSubject;
import com.service.SysSubjectService;

@Controller
@RequestMapping("/admin/subject")
public class SysSubjectController {

	@Autowired
	private SysSubjectService sysSubjectService;
	
	@ResponseBody
	@RequestMapping("/getSubjectList/{state}")
	public List<SysSubject> getSubjectList(@PathVariable("state") Integer state) {
		Map map = new HashMap<>();
		System.out.println(state);
		if (state==2) {
			map.put("parent_id", 0);
		}
		List<SysSubject> sysSubjects = sysSubjectService.listAll(map);
		System.out.println(sysSubjects.size());
		return sysSubjects;
	}
}
