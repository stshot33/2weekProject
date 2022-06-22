package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="signIn", method = RequestMethod.GET)
	public String signIn(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.setAttribute("nick", req.getParameter("nick"));
		session.setAttribute("id", req.getParameter("id"));
		
		return "redirect:main";
	}
	
	@RequestMapping(value="signIn", method = RequestMethod.POST)
	public String kakaoSignIn() {
		
		return "main";
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session.getAttribute("nick") != null) {
			// 로그아웃 시 세션 삭제
			session.invalidate();
			
		}
		
		return "redirect:https://kauth.kakao.com/oauth/logout?client_id=15d3bb1344db4e3cf56966e2788148b8&logout_redirect_uri=http://localhost:8080/routine/main";
	}
}
