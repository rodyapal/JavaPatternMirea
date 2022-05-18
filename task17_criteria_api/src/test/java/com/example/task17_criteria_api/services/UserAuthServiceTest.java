package com.example.task17_criteria_api.services;

import com.example.task17_criteria_api.model.AuthUserDetails;
import com.example.task17_criteria_api.model.entity.User;
import com.example.task17_criteria_api.model.repository.UserRepository;
import com.example.task17_criteria_api.service.UserAuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserAuthServiceTest {
	@Mock private UserRepository userRepository;
	@Mock private PasswordEncoder passwordEncoder;

	private UserAuthService authService;

	@BeforeEach
	void setUp() {
		this.authService = new UserAuthService(userRepository, passwordEncoder);
	}

	@Test
	void testLoadUserByUsername() {
		String username = "TestUsername";
		User user = new User();
		user.setId(-1L); user.setUsername(username); user.setPassword("password");
		Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
		UserDetails testDetails = authService.loadUserByUsername(username);
		Assertions.assertEquals(testDetails.getUsername(), username);
	}

	@Test
	void testSignUpUser() {
		User user = new User();
		user.setId(-1L); user.setUsername("TestUsername"); user.setPassword("password");
		authService.signUpUser(user);
		Mockito.verify(userRepository).save(user);
	}
}
