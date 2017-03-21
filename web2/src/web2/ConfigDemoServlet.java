package web2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemoServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
	
	
	}
	
	@Override
	public void destroy() {
	
	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// ServletContext객체얻기
		ServletContext application = getServletContext();
		String name = application.getInitParameter("companyName");
		String email = application.getInitParameter("admin");
		
		// ServletConfig 객체얻기
		ServletConfig config = getServletConfig();
		String title = config.getInitParameter("pageTitle");
		
		System.out.println("회사명: " + name);
		System.out.println("이메일: " + email);
		System.out.println("제목: " + title);
		
	}
}
