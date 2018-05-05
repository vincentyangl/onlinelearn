package com.controller.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SysSubject;
import com.service.SysSubjectService;
import com.util.JsonUtils;
import com.util.Ztree;

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

	@ResponseBody
	@RequestMapping("/getChildList/{subjectId}")
	public List<SysSubject> getChildList(@PathVariable("subjectId") Integer subjectId) {
		List<SysSubject> child = sysSubjectService.getChildNode(subjectId);
		return child;
	}

	@RequestMapping("/subjectList/{state}")
	public ModelAndView subjectList(@PathVariable("state") Integer state) {
		ModelAndView mv = new ModelAndView();
		List<SysSubject> sysSubjects = sysSubjectService.listAll(new HashMap<>());
		List<Ztree> ztrees = new ArrayList<>();
		for (SysSubject sb : sysSubjects) {
			Ztree ztree = new Ztree();
			ztree.setId(sb.getSubjectId());
			ztree.setpId(sb.getParent_id());
			ztree.setName(sb.getSubjectName());
			ztrees.add(ztree);
		}
		String json = JsonUtils.objectToJson(ztrees);
		mv.addObject("sysSubjects", json);
		
		if(state==0){
			mv.setViewName("/back/subject/subjectList");
		}
		if(state==1){
			mv.setViewName("/back/teacher/teacherAdd");
		}
		return mv;
	}

	@RequestMapping("/subjectAdd")
	public String subjectAdd(SysSubject subject) {
		sysSubjectService.save(subject);
		return "redirect:/admin/subject/subjectList";
	}
}
