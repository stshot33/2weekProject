package routine.fwd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import routine.fwd.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public String testPage() throws Exception{

		System.out.println("controller");
		
		System.out.println(testService.test());
		
//		System.out.println(testService.test2());
		
		return "test";
	}
}
