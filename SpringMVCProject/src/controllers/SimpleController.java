package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {
	
	@RequestMapping(value="/{site}/login.action", method=RequestMethod.GET)
	public String login(@RequestParam("uname") String userName, 
			@RequestParam String password, 
			@PathVariable String site, 
			Model model) {
		String message = "Login processed for " + userName + " in site " + site;
		System.out.println(message);
				
		// send the data to next view
		model.addAttribute("message", message);
		
		return "summary";
	}
}
