package kr.spring.ch05;

public class Memberservice {
	private MemberDAO memberDAO;
	
	public Memberservice(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void send() {
		System.out.println("MemberService method");
		memberDAO.register();
	}
	
}
