package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.UserVO;

public class BookDao {
	
	public UserVO getBookByno(int no) throws SQLException{
		String sql = "select * from skibis_user where no = ?";
		UserVO user = new UserVO();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();  
 

				while (rs.next()) {
					
					user.setNo(rs.getInt("no"));
					user.setName(rs.getString("name"));
					user.setId(rs.getString("id"));
					user.setPw(rs.getString("pw"));
				}
		rs.close();
		
		return user;
	}
	
	
	
	
	public ArrayList<UserVO> getAllUser() throws SQLException {
		
		String sql = "select * from skibis_user";
		
		ArrayList<UserVO> userList = new ArrayList<>();
		try(	Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();  ) {
			while (rs.next()) {
				
				UserVO user = new UserVO();
				user.setNo(rs.getInt("no"));
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				userList.add(user);				
			}
		}
		return userList;
	}
	

}
