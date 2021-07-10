package com.demo2.demo2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo2.demo2.model.log_in;
import com.demo2.demo2.model.position;
import com.demo2.demo2.repository.RoleRepository;
import com.demo2.demo2.repository.loginrepo;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private loginrepo repo;
	
	//@Autowired
	//private RoleRepository posrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		log_in log_in = repo.findByUsername(username);
		
		
		position position = log_in.getPosition();
		if(log_in==null)
			throw new UsernameNotFoundException("error 404");
		
		return new UserPrincipal(log_in, position);
	}

}

