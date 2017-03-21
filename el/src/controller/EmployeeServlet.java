package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Employee;

@WebServlet("/employee.hta")
public class EmployeeServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		Employee employee = new Employee();
		employee.setId(100);
		employee.setName("홍길동");
		employee.setEmail("hong@gmail.net");
		employee.setDept("총무부");
		
		// RequestScope에 Employee객체를 "emp"라는 이름으로 저장
		req.setAttribute("emp", employee);		
		
		// 사원정보를 표시해주는 jsp로 이동시키기
		// employee.jsp로 내부이동 시키는 RequestDispatcher 획득
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/emp/employee.jsp");
		
		// RequestDispatcher의 forward()를 활용해서 emplyee.jsp로 이동시키고,
		// EmployeeServlet이 실행될 때 전달받았던 요청객체 / 응답객체를 전달한다.
		rd.forward(req, res);
		
	}
}
