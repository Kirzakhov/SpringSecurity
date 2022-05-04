package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SpringUser;
import com.example.demo.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SpringUser user = repo.findByName(username);
		if(user==null)
			throw new UsernameNotFoundException("404 Not Found");
		return new UserPrincipal(user);
	}

}
