package com.example.task17_criteria_api.service;

import com.example.task17_criteria_api.model.AuthUserDetails;
import com.example.task17_criteria_api.model.entity.User;
import com.example.task17_criteria_api.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserAuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUserDetails userDetails = new AuthUserDetails(userRepository.findByUsername(username));
		if (userDetails.getUser() == null) {
			throw new UsernameNotFoundException(String.format("Username: %s not found", username));
		}
		return userDetails;
	}

	public String signUpUser(User user) {
		boolean userExists = userRepository.findByUsername(user.getUsername()) != null;
		if (userExists) {
			throw new IllegalStateException(String.format("User with username %s exists", user.getUsername()));
		}

		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));

		userRepository.save(user);
		return "login";
	}
}
