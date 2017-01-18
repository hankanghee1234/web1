package org.kanghee.service;

import java.util.Date;

import org.kanghee.domain.UserVO;
import org.kanghee.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;
	
	public UserVO checkLoginBefore(String value);
}
