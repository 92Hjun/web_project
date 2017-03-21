package demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class BookDAO {
	static final String INSERT_SQL = "INSERT INTO TB_BOOK (NO,TITLE,AUTHOR,PUBLISHER,PRICE,PUBDATE)"
								  + " values (BOOK_SEQ.nextval, ?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'))";
	static final String SERCH_SQL = "select *"
								 + " from TB_BOOK"
								 + " where PUBLISHER = ?";
	
	
	public void addBook (String title, String author, String publisher, int price, String pubdate) throws SQLException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setString(3, publisher);
		ps.setInt(4, price);
		ps.setString(5, pubdate);
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public ArrayList<BookVO> SerchBook (String pub_name) throws SQLException{
		BookVO vo = null;
		ArrayList<BookVO> bookList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SERCH_SQL);
		ps.setString(1, pub_name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			vo = new BookVO();
			vo.setNo(rs.getInt("no"));
			vo.setTitle(rs.getString("title"));
			vo.setAuthor(rs.getString("author"));
			vo.setPublisher(rs.getString("publisher"));
			vo.setPrice(rs.getInt("price"));
			vo.setPubdate(rs.getDate("pubdate"));
			bookList.add(vo);
		}
		rs.close();
		ps.close();
		con.close();
		
		return bookList;
	}
}
