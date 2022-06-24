package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.DietService;
import routine.fwd.vo.MemberVo;

@Controller
public class DietController {
	
	@Autowired
	DietService dietService;
	
	@RequestMapping(value="diet", method = RequestMethod.GET)
	public String diet(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("id")!=null) {
			
			return "diet";
		}else {
			return "redirect:main";
		}
	}
	
	@RequestMapping(value="calorie", method = RequestMethod.GET)
	public String calorie() {
		
		return "calculator";
	}
	
	@RequestMapping(value="calorie", method = RequestMethod.POST)
	public String calcurator(HttpServletRequest req, MemberVo memberVo, Model model) throws Exception {
		HttpSession session = req.getSession();
		long id = Long.parseLong((String)session.getAttribute("id"));
		
		memberVo.setM_id(id);
		
		model.addAttribute("calorie", dietService.calculator(memberVo));
		
		return "calculator";
	}
}
