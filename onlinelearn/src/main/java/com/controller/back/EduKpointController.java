package com.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.EduKpointService;

@Controller
@RequestMapping("/admin/kpoint")
public class EduKpointController {

	@Autowired
	private EduKpointService eduKpointService;
	
	
	
}
