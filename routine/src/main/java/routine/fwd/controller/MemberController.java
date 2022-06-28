package routine.fwd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.MemberService;
import routine.fwd.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="signIn", method = RequestMethod.GET)
	public String signIn(HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		String nick = req.getParameter("nick");
		String id = req.getParameter("id");
		
		session.setAttribute("nick", nick);
		session.setAttribute("id", id);
		
		kakaoSignIn(id, nick);
		
		return "redirect:main";
	}
	
	public void kakaoSignIn(String id, String nickname) {
		MemberVo memberVo = new MemberVo();
		
		memberVo.setM_id(Long.parseLong(id));
		memberVo.setM_nickname(nickname);
		
		try {
			memberService.saveInfo(memberVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
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
