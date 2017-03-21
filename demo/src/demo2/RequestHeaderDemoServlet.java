package demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/h")
public class RequestHeaderDemoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String host = req.getHeader("host");
		String user = req.getHeader("user-agent");
		String accept = req.getHeader("accept-encoding");
		
		System.out.println(host);
		System.out.println(user);
		System.out.println(accept);
	
	}
}
