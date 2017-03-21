package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunningTimePrintFilter implements Filter{

	@Override
	public void destroy() {

		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)throws IOException, ServletException {
		
		//실행 전 처리 코드
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpRes = (HttpServletResponse) res;
		
		String requestURI = httpReq.getRequestURI(); // 결과 : /model2_login/home.hta
		String contextPath = httpReq.getContextPath(); // 결과 : /model2_login
		requestURI = requestURI.replace(contextPath, "");// 결과 : /home.hta
		
		long begin = System.currentTimeMillis();
		filterChain.doFilter(req, res);
		
		// 실행 후 처리 코드
		long end = System.currentTimeMillis();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
	}
	
}
