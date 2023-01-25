package kr.spring.ch07.service;

import kr.spring.ch07.vo.LoginVO;

public class LoginService {
	public static void checkLogin(LoginVO vo) throws LoginCheckException{
		
		
		//테스트 용 userID, password가 같으면 로그인 성공 
		if(!vo.getUserId().equals(vo.getPassword())) {
			//로그인 실패 
			System.out.println("인증 실패 - "+vo.getUserId());
			throw new LoginCheckException();
		}
		
	}
}
