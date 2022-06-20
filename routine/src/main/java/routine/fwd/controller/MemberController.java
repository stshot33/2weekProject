package routine.fwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="signIn", method = RequestMethod.GET)
	public String signIn() {
		return "login";
	}
	
	@RequestMapping(value="signIn", method = RequestMethod.POST)
	public String kakaoSignIn() {
		return "main";
	}
}
