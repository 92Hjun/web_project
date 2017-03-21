package product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/del")
public class ProductDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pno = Integer.parseInt(req.getParameter("pno"));
		ProductDAO dao = new ProductDAO();
		try{
			dao.deleteProduct(pno);
			res.sendRedirect("login");
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	
	}
}
