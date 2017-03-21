package demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 어노테이션 부가적인 설정정보
@WebServlet(urlPatterns={"/sample"})
							    // http프로토콜을 기반으로하는 서블릿
public class SampleServlet extends HttpServlet {
	
	@Override	  // get 요청을 처리한다.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet의 doGet() 메소드가 실행됨...");
		
		// 클라이언트로 html컨텐츠 제공하기
		// 현재 날짜와 시간정보를 가진 Date객체 만들기
		Date now = new Date();
		
		//클라이언트로 컨텐츠를 출력(전송)하는 스트립 얻기 
		PrintWriter out = resp.getWriter();
		
		//스트림을 활용해서 클라이언트로 데이터 내보내기
		out.print("<html>"
				+ "<head>"
				+ "<title>Current Time</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Current Time is " + now + "</h1>"
				+ "</body>"
				+ "</html>");
	}
	
}
