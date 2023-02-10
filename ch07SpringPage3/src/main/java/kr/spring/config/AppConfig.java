package kr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.spring.interceptor.AdminCheckInterceptor;
import kr.spring.interceptor.AutoLoginCheckInterceptor;
import kr.spring.interceptor.LoginCheckInterceptor;
import kr.spring.interceptor.WriterCheckInterceptor;

//자바코드 기반 설정 클래스
@Configuration
public class AppConfig implements WebMvcConfigurer{

	private AutoLoginCheckInterceptor autoLogin;
	private LoginCheckInterceptor loginCheck;
	private AdminCheckInterceptor adminCheck;
	private WriterCheckInterceptor writerCheck;
	
	@Bean
	public AutoLoginCheckInterceptor interceptor() {
		autoLogin = new AutoLoginCheckInterceptor();
		return autoLogin;
	}
	
	@Bean
	public LoginCheckInterceptor interceptor2() {
		loginCheck = new LoginCheckInterceptor();
		return loginCheck;
	}
	
	@Bean
	public AdminCheckInterceptor interceptor3() {
		adminCheck = new AdminCheckInterceptor();
		return adminCheck;
	}
	
	@Bean
	public WriterCheckInterceptor interceptor4() {
		writerCheck = new WriterCheckInterceptor();
		return writerCheck;
	}
	
	//인터셉터 등록
	@Override
	public void addInterceptors(
			     InterceptorRegistry registry) {
		//AutoLoginCheckInterceptor 설정
		registry.addInterceptor(autoLogin)
				.addPathPatterns("/**")
				.excludePathPatterns("/member/login.do")
				.excludePathPatterns("/member/logout.do");
		//LoginCheckInterceptor 설정
		registry.addInterceptor(loginCheck)
		        .addPathPatterns("/member/myPage.do")
		        .addPathPatterns("/member/update.do")
		        .addPathPatterns("/member/changePassword.do")
		        .addPathPatterns("/member/delete.do")
		        .addPathPatterns("/board/write.do")
		        .addPathPatterns("/board/update.do")
		        .addPathPatterns("/board/delete.do");
		//AdminCheckInterceptor 설정
		registry.addInterceptor(adminCheck)
		        .addPathPatterns("/main/admin.do")
		        .addPathPatterns("/member/admin_list.do")
		        .addPathPatterns("/member/admin_update.do");
		//WriterCheckInterceptor 설정
		registry.addInterceptor(writerCheck)
		        .addPathPatterns("/board/update.do")
		        .addPathPatterns("/board/delete.do");
	}
	
	//타일스 설정
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer =
				new TilesConfigurer();
		//해당 경로에 xml 설정 파일을 넣음
		configurer.setDefinitions(new String[] {
				"/WEB-INF/tiles-def/main.xml",
				"/WEB-INF/tiles-def/member.xml",
				"/WEB-INF/tiles-def/board.xml"
		});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver tilesViewResolver = 
				new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}
}



