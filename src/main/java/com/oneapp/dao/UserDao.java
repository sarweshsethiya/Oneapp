package com.oneapp.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oneapp.bean.UserDetails;
import com.oneapp.constants.OneAppConstants;


@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Map saveUserDetails(UserDetails ud) {
		
		String sql = OneAppConstants.INSERT_USER_DETAILS;
		
		Object[] logArgs =  {ud.getName(),ud.getEmailId(),ud.getPassword(), ud.getMessage()};
		
		System.out.println(jdbcTemplate);
		
		jdbcTemplate.update(sql, logArgs);
		
		Map<String,Object> udMap = new HashMap<String,Object>();
		
		udMap.put("id", "");
		udMap.put("name", ud.getName());
		udMap.put("emailId", ud.getEmailId());
		udMap.put("message", ud.getMessage());
			
		return udMap;
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
