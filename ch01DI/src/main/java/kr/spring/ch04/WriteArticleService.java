package kr.spring.ch04;

public class WriteArticleService {
	private WriteArticleDAO writeArticleDAO;
	
	//생성자에서 DAO를 변수로 받음 (의존)
	public WriteArticleService(WriteArticleDAO writeArticleDAO) {
		this.writeArticleDAO = writeArticleDAO;
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write method 실행");
		writeArticleDAO.insert();
	}
}
