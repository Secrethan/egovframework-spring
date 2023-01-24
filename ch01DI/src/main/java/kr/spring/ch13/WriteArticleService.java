package kr.spring.ch13;

public class WriteArticleService {
	private WriteArticleDAO writeArticleDAO;

	public void setWriteArticleDAO(WriteArticleDAO writeArticleDAO) {
		this.writeArticleDAO = writeArticleDAO;
	}

	
	public void write() {
		System.out.println("writearticleservice write method");
		writeArticleDAO.insert();
	}
	
	
}
