package com.seclore.todolist.repository;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seclore.todolist.domain.UserDetails;

@Repository
public class UserDetailsRepository implements UserDetailsRepositoryInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_NEW_USER = "INSERT INTO user_details (name,mobile_no,email,password)  values(?,?,?,?)";
	private static final String GET_USER = "SELECT * from user_details where email = ?";
	


	@Override
	public boolean addNewUser(UserDetails userDetails) {
		Object[] args = {userDetails.getUserId(),userDetails.getMobileNo(),userDetails.getEmail(),userDetails.getPassword()};
		int rowCount;
		try {
			rowCount = jdbcTemplate.update(INSERT_NEW_USER,args);
		} catch(Exception e){
			return false;
		}
		if(rowCount>0) return true;
		return false;
	}

	@Override
	public UserDetails getUserByEmail(String email) {
		UserDetailsRowMapper userDetailsRowMapper = new UserDetailsRowMapper();
		
		UserDetails userDetails = jdbcTemplate.queryForObject(GET_USER, userDetailsRowMapper,email);
		
		return userDetails;
	}

}