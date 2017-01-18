package org.kanghee.service;

import java.util.Date;

import org.kanghee.domain.UserVO;
import org.kanghee.dto.LoginDTO;
import org.kanghee.persistence.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAOImpl dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) throws Exception {
		
		dao.keepLogin(uid, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) {
		
		return dao.checkUserWithSessionKey(value);
	}

}
