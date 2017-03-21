package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.BlogVO;

public class BlogDAO {
	
	public ArrayList<BlogVO> getBlogList () throws SQLException {
		
		String sql = "select no, title, writer, contents, regdate, group_no"
				  + " from tb_blog"
				  + " order by group_no desc, no asc";
		
		ArrayList<BlogVO> list = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			BlogVO blog = new BlogVO();
			
			blog.setNo(rs.getInt("no"));
			blog.setTitle(rs.getString("title"));
			blog.setWriter(rs.getString("writer"));
			blog.setContents(rs.getString("contents"));
			blog.setRegdate(rs.getDate("regdate"));
			blog.setGroupNo(rs.getInt("group_no"));
			
			list.add(blog);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		return list;
		
	}
	
	public int getSeq ()  throws SQLException{
		String sql = "select comm_seq.nextval seq from dual";
		int no = 0;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		no = rs.getInt("seq");
		
		rs.close();
		ps.close();
		con.close();
		
		return no;
	}
	
	public void setBoard (BlogVO blog) throws SQLException {
		
		String sql = "insert into tb_blog (no,title,writer,contents,group_no)"
				  + " values(?, ?, ?, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, blog.getNo());
		ps.setString(2, blog.getTitle());
		ps.setString(3, blog.getWriter());
		ps.setString(4, blog.getContents());
		ps.setInt(5, blog.getGroupNo());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
	
	public BlogVO getBlogByNo (int no) throws SQLException {
		
		String sql = "select no, title, writer, contents, regdate, group_no"
				  + " from tb_blog"
				  + " where no = ?";
		BlogVO blog = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			blog = new BlogVO();
			blog.setNo(rs.getInt("no"));
			blog.setTitle(rs.getString("title"));
			blog.setWriter(rs.getString("writer"));
			blog.setContents(rs.getString("contents"));
			blog.setRegdate(rs.getDate("regdate"));
			blog.setGroupNo(rs.getInt("group_no"));
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return blog;
		
	}
}
