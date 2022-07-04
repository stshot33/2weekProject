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

import routine.fwd.service.BoardService;
import routine.fwd.vo.AnswerVo;
import routine.fwd.vo.ExBoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="foodBoard", method = RequestMethod.GET)
	public String foodBoard(Model model) {
		try {
			model.addAttribute("boardInfo", boardService.allexBoard(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "exBoard";
	}
	
	@RequestMapping(value="exBoard", method = RequestMethod.GET)
	public String exBoard(Model model) {
		try {
			model.addAttribute("boardInfo", boardService.allexBoard(2));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "exBoard";
	}
	
	@RequestMapping(value="qna", method = RequestMethod.GET)
	public String qna(Model model) {
		try {
			model.addAttribute("boardInfo", boardService.allexBoard(3));
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
		String boardName = req.getParameter("board");		
		try {
			System.out.println(session.getAttribute("id"));
			
			if(boardName.equals("foodBoard")) {
				exBoardVo.setB_diff(1);
			}
			
			if(boardName.equals("exBoard")) {
				exBoardVo.setB_diff(2);
			}
			
			if(boardName.equals("qna")) {
				exBoardVo.setB_diff(3);
			}
			
			exBoardVo.setExm_id(Long.parseLong((String)session.getAttribute("id")));
			exBoardVo.setExm_name((String)session.getAttribute("nick"));
			
			boardService.exboardInsert(exBoardVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:" + boardName;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest req, Model model) {
		int ano = Integer.parseInt(req.getParameter("no"));
		
		try {
			boardService.lookPlus(Integer.parseInt(req.getParameter("no")));
			model.addAttribute("detail", boardService.detail(ano));
			
			if(boardService.allAnswer(ano).size()>0 ) {
				model.addAttribute("answers", boardService.allAnswer(ano));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "exBoard/detail";
	}
	
	@ResponseBody
	@RequestMapping(value="answer", method = RequestMethod.POST)
	public ModelAndView answer(HttpServletRequest req, AnswerVo answerVo) {
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		
		int ano = Integer.parseInt(req.getParameter("no"));
		answerVo.setAexb_no(ano);
		answerVo.setAm_name((String)session.getAttribute("nick"));
		
		mv.setViewName("jsonView");
		try {
			boardService.addAnswer(answerVo); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
}
