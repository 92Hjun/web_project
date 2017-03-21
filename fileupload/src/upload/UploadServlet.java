package upload;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.GalleryDAO;
import vo.GalleryVO;

//멀티파트요청을 처리할 수 있는 서블릿으로 지정한다.
// 없으면 getparameter를 사용해도 읽어올수 없다
@MultipartConfig
@WebServlet(urlPatterns="/upload.hta")
public class UploadServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		// 입력필드의 단순 텍스트 값 가져오기
		String username = req.getParameter("username");
		String description = req.getParameter("description");
		System.out.println("작성자 이름: " + username);
		System.out.println("설명: " + description);
		
		// 첨부파일 처리하기
		Part part = req.getPart("photofile");
		String filename = getFilename(part);
		
		// 실제 경로알아내기
		ServletContext application = this.getServletContext();
		String galleyDir = application.getRealPath("gallery");
		System.out.println("갤러리 디렉토리 경로: " + galleyDir);
		
		// 첨부파일이 있는 경우
		if(filename != null && !filename.isEmpty()) {
			
			System.out.println("첨부파일명: " + filename);
			
			// 파일을 gallery폴더에 저장하기
			part.write(galleyDir + "/" + filename);
			
		}
		GalleryVO gallery = new GalleryVO();
		gallery.setUsername(username);
		gallery.setDescription(description);
		gallery.setFilename(filename);
		
		GalleryDAO dao = new GalleryDAO();
		
		try {
			dao.addGallery(gallery);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		res.sendRedirect("gallery.jsp");
		
	}
	
	private String getFilename(Part part) {
		
		//헤더의 문자열을가져옴
		String headerValue = part.getHeader("Content-Disposition");
		
		//가져온 문자열을 ; 로 나눔
		String[] elements = headerValue.split(";");
		
		// for문으로 나눈 문자열을 String 타입으로 대입함
		for (String el : elements){
			
			// filename이라는 이름으로 시작하는지 체크
			if(el.trim().startsWith("filename")){
					  //el에 filename으로 시작하는 것이면 =부터 읽어서 "쌍따옴표를 "" 공백으로 바꿔주고 리턴함
				return el.substring(el.indexOf("=")+1).replace("\"", "");
				
			}
		}
		// filename이 없으면 null이 반환됨
		return null;
				
	}
	
}
