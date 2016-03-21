package hello;

import model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/oauth")
@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
	// @ResponseBody
	String home() {

		System.out.println("in home()");
		return "hello"; // jsp?
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
