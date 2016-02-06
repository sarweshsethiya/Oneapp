package com.oneapp.delegate;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneapp.bean.UserDetails;
import com.oneapp.dao.UserDao;

@Service
public class UserDelegate {

	@Autowired
	UserDao mUserDao;
		
	public Map saveUserDetails(UserDetails ud){
		
		Map m = mUserDao.saveUserDetails(ud);
		
		return m;
		
	}
	
	
	
}
