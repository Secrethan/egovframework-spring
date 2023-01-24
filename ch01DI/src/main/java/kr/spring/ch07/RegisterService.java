package kr.spring.ch07;

public class RegisterService {
	private RegisterDAO registerDAO;

	//의존 관계 설정 방식 : 프로퍼티
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public void write() {
		System.out.println("RegisterService write method");
		
		registerDAO.insert();
	}
	
	
}
