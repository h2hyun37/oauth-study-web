package hello;

import model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
// @RequestMapping(value = "/oauth")
@SpringBootApplication
public class SampleController {

	@RequestMapping("/1")
	// @ResponseBody
	String home(Model model) {

		System.out.println("in home() - 2");

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("hello");

		// return mav;
		return "hello"; // jsp?
	}


	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

		System.out.println("in greeting() - 2");

		model.addAttribute("name", name);
		return "greeting";
	}


	@RequestMapping(value = "/{userNumber}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long userNumber) {

		User user = new User();

		user.setNumber(userNumber);

		return user;

	}

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}

}
