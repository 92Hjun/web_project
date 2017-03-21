package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CharacterEncodingFilter implements Filter{
	
	private String defaultEncoding = null;
	
	// Filter객체가 생성되고 초기화작업을 위해서 딱 한번 실행된다.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		defaultEncoding = filterConfig.getInitParameter("encoding");
		if (defaultEncoding == null) {
			defaultEncoding = "UTF-8";
		}
		
	}
	
	// Filter객체가 소멸되기직전에 딱 한번 실행된다.
	// 연결된 리소스(자원)해제 작업을 코딩하면 된다.
	// 일반적으로 아무작업도 안한다.
	@Override
	public void destroy() {}

	// Filter객체의 실질적인 작업내용을 구현하는 메소드다.
	// 클라이언트의 요청을 가로채서 서블릿/JSP 실행전에 매번 실행된다.
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
		
		
		
		req.setCharacterEncoding(defaultEncoding);
		// 이 필터 다음 필터의 doFilter() 메소드를 실행한다.
		// 필터가 더이상 존재하지않으면 서블릿/JSP의 service() 메소드를 실행한다.
		// filterChain.doFilter() 이전에 작성한 코드는 전처리 코드가되고 filterChain.doFilter()이후에 작성한 코드는 후처리코드가 된다.
		filterChain.doFilter(req, res);
		
	}

	
	
}
