package com.demo2.demo2.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo2.demo2.model.log_in;

import com.demo2.demo2.model.position;
import com.demo2.demo2.repository.RoleRepository;

public class UserPrincipal implements UserDetails {
	
	private log_in user;
	private position position;


	

	
	

	public UserPrincipal(log_in user , position position) {
		super();
		this.user = user;
		this.position=position;
		//this.position=position;
	}
	
	
  

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		//System.out.print(user);

		return Collections.singleton(new SimpleGrantedAuthority(position.getPosname()));
		//return Collections.singleton(set"user",)
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
