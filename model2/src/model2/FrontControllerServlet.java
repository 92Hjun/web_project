package model2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddController;
import controller.FormController;
import controller.HomeController;
import controller.ListController;

@WebServlet("*.hta")
public class FrontControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String requestUri = req.getRequestURI().replace("/model2", "");
		
		try {
			
			Controller controller = null;
			
			if ("/home.hta".equals(requestUri)) {
				controller = new HomeController();
			} else if ("/list.hta".equals(requestUri)) {
				controller = new ListController();
			} else if ("/form.hta".equals(requestUri)) {
				controller = new FormController();
			} else if ("/add.hta".equals(requestUri)) {
				controller = new AddController();
			}
			
			// 유효하지 않은 url요청인 경우 controller는 null이다.
			if (controller == null) {
				throw new ServletException("유효한 URL이 아닙니다.");
			}
			
			// 컨트롤러 실행하기
			// 컨트롤러는 이동할 경로를 반환한다.
			String path = controller.process(req, res);
			
			if (path == null) {
				throw new ServletException("컨트롤러가 이동할 경로를 반환하지 않습니다.");
			}
			
			String[] arr = path.split(":");
			if (arr[0].equals("forward")) {
				
				req.getRequestDispatcher("WEB-INF/views/"+arr[1]).forward(req, res);
				
			}else if (arr[0].equals("redirect")) {
				
				res.sendRedirect(arr[1]);
			}
			
			
		} catch (ServletException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
