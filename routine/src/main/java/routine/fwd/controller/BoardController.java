package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.BoardService;
import routine.fwd.vo.ExBoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="exBoard", method = RequestMethod.GET)
	public String exBoard(Model model) {
		try {
			model.addAttribute("boardInfo", boardService.allexBoard());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "exBoard";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String addBoard() {
		
		return "exBoard/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String addBoard(HttpServletRequest req, ExBoardVo exBoardVo) {
		HttpSession session = req.getSession();
		
		try {
			System.out.println(session.getAttribute("id"));
			
			exBoardVo.setExm_id(Long.parseLong((String)session.getAttribute("id")));
			exBoardVo.setExm_name((String)session.getAttribute("nick"));
			
			boardService.exboardInsert(exBoardVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:exBoard";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest req) {
		
		System.out.println(req.getParameter("no"));
		
		
		return "exBoard/detail";
	}
	
}
