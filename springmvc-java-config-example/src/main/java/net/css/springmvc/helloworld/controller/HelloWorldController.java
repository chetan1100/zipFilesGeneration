package net.css.springmvc.helloworld.controller;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.css.springmvc.helloworld.model.HelloWorld;


@Controller
public class HelloWorldController {
	
	@RequestMapping("/helloworld")
	public String handler(Model model) {
		HelloWorld helloworld=new HelloWorld();
		helloworld.setMessage("Hello Workld Example using Spring MVC");
		helloworld.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("helloworld",helloworld);
		
		return "helloworld";
	}
}
