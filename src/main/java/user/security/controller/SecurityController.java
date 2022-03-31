package user.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import user.security.dto.Users;
import user.security.service.UsersService;

@Controller
public class SecurityController {
	
	@Autowired
	UsersService uservice;

	@GetMapping("/")
	public String index() {
		System.out.println("index요청입니다");
		return "index";
	}
	
	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member 요청입니다");
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("manager요청입니다");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin요청입니다");
	}
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
	
	@GetMapping("/insert")
	public String insert(Users users) {
		uservice.insertUser(users);
		return "redirect:/";
	}
}
