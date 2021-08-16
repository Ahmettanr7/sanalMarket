package AhmetTanrikulu.sanalMarket.api.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AhmetTanrikulu.sanalMarket.business.abstracts.UserService;
import AhmetTanrikulu.sanalMarket.core.utilities.results.DataResult;
import AhmetTanrikulu.sanalMarket.entities.concretes.User;

@RestController
@RequestMapping("/api/users/")
@CrossOrigin
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("getbyemail")
	public DataResult<User> getByEmail(String email) {
		return this.userService.getByEmail(email);
	}
	
	@GetMapping("getbyid")
	public DataResult<User> getById(int id) {
		return this.userService.getById(id);
	}
	
	@GetMapping("getbyusername")
	public DataResult<User> getByUserName(String userName) {
		return this.userService.getByUserName(userName);
	}

}
