package kr.spring.ch18;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 코드 기반 설정
//설정파일을 만들지 않고 설정을 담당하는 클래스를 구현
@Configuration
public class SpringConfig {

	//@Bean 어노테이션을 명시함으로써 bean 객체 설정
	//@Bean을 명시해서 빈객체를 생성할 때는 메소드명을 빈객체의 이름으로 사용
	//@Bean("빈이름")으로 변경 가능 
	@Bean
	public Worker worker() {
		return new Worker();
	}
	@Bean
	public Executor executor() {
		return new Executor();
	}
}
