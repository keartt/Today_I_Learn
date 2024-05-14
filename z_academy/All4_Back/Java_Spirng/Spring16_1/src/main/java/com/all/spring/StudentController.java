package com.all.spring;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("student")
	public String Student_create() {
		return "/createPage";
	}
	
	@RequestMapping("student/create")
	//@ModelAttribute("student") 
	public String Student_result(Student student , BindingResult result) {
		
		// 문제가 없으면 갈 페이지
		String page ="createDonePage";
		
		
		/* 문제가 발생하면 갈 페이지  
		 * 만들었던 validator 에  받은 student 랑 
		 *  가질 결과 result 를 던져준다 */
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if (result.hasErrors()) {
			// redirect : url 바껴서 처리 돌아가서
			page="redirect:/student";
		}
		return page;
	}

}
