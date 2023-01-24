package kr.spring.ch16;

import javax.annotation.Resource;

public class HomeController {
	//빈의 이름과 프로퍼티명이 일치하면 의존 관계 설정 
	@Resource
	private Camera cameral1;
	@Resource 
	private Camera camera2;

	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
	}

	public void setCameral1(Camera cameral1) {
		this.cameral1 = cameral1;
	}

	@Override
	public String toString() {
		return "HomeController [cameral1=" + cameral1 + ", camera2=" + camera2 + "]";
	}
	
	
}
