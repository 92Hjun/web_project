package demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/life")
public class LifeCycledemoServlet extends HttpServlet{
	
	public LifeCycledemoServlet() {
		System.out.println("LifeCycledemoServlet constuctor is running");
	}
	
	@Override	// 객체 생성직후 초기화하는 메소드 객체생성시 처음 한번만 실행한다.
	public void init() throws ServletException {
		
		System.out.println("init() running");
	
	}
	
	@Override	// 초기화한 메소드에 요청, 응답이 오면 실행되는 메소드, 요청이 들어올때마다 실행된다.
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw =res.getWriter();
		pw.println("Hello!!!");
	
	}
	
	@Override	// 실행을 다 마친후, 톰캣이 꺼졌을때나 service 메소드가 바뀌었을때 실행.
	public void destroy() {
		System.out.println("destroy() is running");
	
	}
	
}
