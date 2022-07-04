package routine.fwd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="main", method = RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("recentf", boardService.recent(1));
		model.addAttribute("recentex", boardService.recent(2));
		
		return "main/main";
	}
}
