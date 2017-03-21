package repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String directory = "c:/web_project/repo";
		String fileName = req.getParameter("name");
		
		String encodedFileName = URLEncoder.encode(fileName, "utf-8");
		
		
		res.setContentType("application/octet-stream");
		
		res.setHeader("Content-disposition", "attachment;filename=" + encodedFileName);
		
		FileInputStream fis = new FileInputStream(new File(directory, fileName));
		
		OutputStream os = res.getOutputStream();
		
		IOUtils.copy(fis, os);
	}
}
