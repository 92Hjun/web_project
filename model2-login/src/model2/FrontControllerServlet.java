package model2;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*프론트컨트롤 서블릿은 대부분 *로 처리함*/
@WebServlet("*.hta")
public class FrontControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String requestURI = req.getRequestURI().replace("/model2-login", "");
		/* 식별을 목적으로 하는 URL을 URI 라고 합니다. */

		try {
			
			ServletContext application = this.getServletContext();
			Map<String, Controller> controllers =(Map<String, Controller>) application.getAttribute("controllersMap");
			Controller controller = controllers.get(requestURI);
			
			// 유요하지 않은 Url요청인 경우
			if ( controller == null ) {
				throw new ServletException("유효한 URL이 아닙니다. (controller is null)");
			}
			
			// 컨트롤러 실행하기
			// 컨트롤러는 이동할 경로를 반환한다.
			String path = controller.process(req, res);
			
			if(path == null) {
				throw new ServletException("컨트롤러가 이동할 경로를 반환하지 않습니다.");
			}
			
			// 포워드 방식인지 리다이렉트 방식인지 확인
			String[] arr = path.split(":");
			if(arr[0].equals("forward")) {
				req.getRequestDispatcher("WEB-INF/views/" + arr[1]).forward(req, res);
			} else if (arr[0].equals("redirect")){
				res.sendRedirect(arr[1]);
			}
			
		} catch (ServletException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("요청처리중 에러 발생");
		}
	}
}
