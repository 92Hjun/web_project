package sample2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vo.Emp;
@WebServlet("/getData")
public class DemoJSONPServlet  extends HttpServlet{
	
	// 서비스 제공자로서의 JSONP
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String methodName = req.getParameter("callback");
		System.out.println("콜백메소드명" + methodName);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		Emp emp = new Emp(100, "홍", "길동", "010-1234-1234", "영업부", 3000000, 0.1);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(emp);
		
		String script = methodName + "("+jsonData+")";
		
		out.write(script);
		
		
		
	}
}
