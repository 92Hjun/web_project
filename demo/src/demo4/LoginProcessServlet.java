package demo4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/loginprocess.hta")
public class LoginProcessServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 아이디/비밀번호 가져오기
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// 가입했을 때 아이디/비밀번호와 일치하는지 체크하기
		if ("hong".equals(id) && "zxcv1234".equals(pwd)) {
			
			// HTTPSession객체를 생성하기		//sessionId 가 없으면 Session객체를 만든다.
			HttpSession session = req.getSession(true);
			
			// 세션이 액티브되어 있는 시간을 설정한다.(초단위)
			session.setMaxInactiveInterval(60*1);
			System.out.println("세션 아이디: " + session.getId());
			
			//HttpSession객체에 사용자신원 정보 저장하기
			session.setAttribute("loginedId", id);
			session.setAttribute("loginedname", "홍길동");
			session.setAttribute("recentLogionedDate", "2017.01.10");
			res.sendRedirect("login.hta");
		}else {
			res.sendRedirect("login.hta?err=fail");
		}
	}
}
