package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.ExService;

@Controller
public class ExController {
	
	@Autowired
	ExService exService;
	
	@RequestMapping(value="exercise", method = RequestMethod.GET)
	public String exercise(HttpServletRequest req, Model model) throws Exception {
		int target = Integer.parseInt(req.getParameter("target"));
		
		try {
			if(target>0) {
				model.addAttribute("allEx");
				
				model.addAttribute("target", exService.target(target));
				model.addAttribute("targetAll", exService.allEx(target));
				
				return "exercise";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "exercise";
	}
}
