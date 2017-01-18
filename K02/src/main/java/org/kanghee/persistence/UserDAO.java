package org.kanghee.persistence;

import java.util.Date;

import org.kanghee.domain.UserVO;
import org.kanghee.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
