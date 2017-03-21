package demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/req")
public class RequestDemoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 선택된 체크박스의 값을 가져온다.
		// 선택된 체크박스가 하나도 없는경우 null이 반환된다.
		String[] lan = req.getParameterValues("lan");
		
		if (lan != null) {
			for (String lang: lan) {
				System.out.println(lang);
			}			
		}else{
			System.out.println("아무것도 선택하지 않음.");
		}
		
		// 자격증 입력필드의 값을 조회한다.
		// 자격증 입력필드에 하나도 값이 입력되어 있지 않아도 "빈공백"인 값은 무조건 전달된다.
		String[] licence = req.getParameterValues("licence");
			for (String l : licence) {
				if (l.equals("")) {
					System.out.println("자격증이 입력되지 않았음");
					break;
				}
				System.out.println("자격증 이름: "+ l);
			}
	}
}
