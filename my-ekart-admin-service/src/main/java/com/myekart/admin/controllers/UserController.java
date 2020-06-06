package com.myekart.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myekart.admin.user.exception.UserException;
import com.myekart.admin.user.service.UserService;
import com.myekart.messaging.admin.user.UserRequest;
import com.myekart.messaging.admin.user.UserResponse;
import com.myekart.utilities.config.exception.ApplicationExceptionHandler;

@RestController
@RequestMapping("/users")
public class UserController extends ApplicationExceptionHandler {

	@Autowired
	private UserService userService;

	@PostMapping("/sign-up")
	public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest request) throws UserException {
		return new ResponseEntity<UserResponse>(userService.createUser(request), HttpStatus.CREATED);
	}

	@GetMapping("/{username}/get-user")
	public ResponseEntity<UserResponse> getUser(@PathVariable("username") String username) throws UserException {
		return new ResponseEntity<UserResponse>(userService.fetchUserDetails(username), HttpStatus.OK);
	}

}
