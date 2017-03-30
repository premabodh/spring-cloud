package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		System.out.println("In Custom Userdeail Service");
		try{
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM my_user WHERE username='roy'");
		while(rs.next())
		{
			String password = rs.getString("password");
			System.out.println(password);
			return new org.springframework.security.core.userdetails.User(
					arg0, password, true,
					true, true, true,
                    AuthorityUtils.createAuthorityList("ROLE_CLIENT", "write"));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
