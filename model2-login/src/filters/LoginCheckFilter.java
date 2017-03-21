package filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpRes = (HttpServletResponse) res;
		// contextPath는 웹 애플리케이션을 다른 웹 애플리케이션과 구분짓는 경로다.
		// 보통은 "/" + 웹애플리케이션프로젝트명 이다.
		
		
		// 요청 url 분석
		// 입력 : http://localhost/model2_login/home.hta
		String requestURI = httpReq.getRequestURI(); // 결과 : /model2_login/home.hta
		String contextPath = httpReq.getContextPath(); // 결과 : /model2_login
		requestURI = requestURI.replace(contextPath, "");// 결과 : /home.hta
		
		
		// 로그인이 필요없는 url경로를 담는 Set객체
		Set<String> urlSet = new HashSet<>();
		urlSet.add("/home.hta");
		urlSet.add("/form.hta");
		urlSet.add("/add.hta");
		urlSet.add("/loginform.hta");
		urlSet.add("/login.hta");
		
		boolean isRequireLogin = false;
		
		// 로그인이 필요한 요청인지 확인 
		if (!urlSet.contains(requestURI)){
			isRequireLogin = true;
		}
		
		
		if (isRequireLogin) {
			// 로그인이 필요한 url을 요청한 경우
			HttpSession session = httpReq.getSession(false);
			if (session == null) {
				httpRes.sendRedirect("loginform.hta?err=deny");
				return;
			}
			if (session.getAttribute("LOGINED_USER") == null) {
				httpRes.sendRedirect("loginform.hta?err=deny");
				return;
			}
			filterChain.doFilter(req, res);
		} else {
			// 로그인이 필요없는 url을 요청한 경우
			filterChain.doFilter(req, res);
		}
			
		
		
		
	}

	
}
