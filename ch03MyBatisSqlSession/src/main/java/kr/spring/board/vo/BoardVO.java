package kr.spring.board.vo;

import java.sql.Date;

public class BoardVO {
	private int num;
	private String write;
	private String title;
	private String passwd;
	private String content;
	private Date reg_date;
	
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", write=" + write + ", title=" + title + ", passwd=" + passwd + ", content="
				+ content + ", reg_date=" + reg_date + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}

