package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import routine.fwd.service.DietService;
import routine.fwd.vo.MemberVo;
import routine.fwd.vo.RoutineVo;

@Controller
public class DietController {
	
	@Autowired
	DietService dietService;
	
	@RequestMapping(value="diet", method = RequestMethod.GET)
	public String diet(HttpServletRequest req, Model model) throws Exception {
		HttpSession session = req.getSession();
		try {
			if(session.getAttribute("id")!=null) {
				
				model.addAttribute("diet", dietService.diet(Long.parseLong((String)session.getAttribute("id"))));
				
				return "diet";
			}else {
				return "redirect:main";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:main";
	}
	
	@RequestMapping(value="calorie", method = RequestMethod.GET)
	public String calorie() {
		
		return "calculator";
	}
	
	@ResponseBody
	@RequestMapping(value="calorie", method = RequestMethod.POST)
	public ModelAndView calcurator(HttpServletRequest req, MemberVo memberVo, Model model) throws Exception {
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		
		long id = Long.parseLong((String)session.getAttribute("id"));
		
		memberVo.setM_id(id);
		
		mv.setViewName("jsonView");
		
		mv.addObject("calorie", dietService.calculator(memberVo));
		
		return mv;
	}
	
	@RequestMapping(value="routineProgram", method = RequestMethod.GET)
	public String routineProgram() throws Exception {
		return "routineProgram";
	}
	
	@RequestMapping(value="routineProgram", method = RequestMethod.POST)
	public String routineProgram(RoutineVo routineVo, Model model) {
		
		int dvs = routineVo.getDivision();
		
		if(dvs!= 0) {
			try {
				model.addAttribute("division", dietService.routineDivision(routineVo));
				model.addAttribute("dvs", routineVo);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return "myRoutine";
		}else {
			
			return "redirect:routineProgram";
		}
	}
	
	@RequestMapping(value="myRoutine", method = RequestMethod.GET)
	public String myRoutine(HttpServletRequest req) {
		
		return "myRoutine";
	}
}
