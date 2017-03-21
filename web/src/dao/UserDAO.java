package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;
import vo.UserVO;

public class UserDAO {
	
	public UserVO getUserById (String id) throws SQLException {
		String sql = "select USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_ADDR, USER_REGDATE, USER_POINT"
				  + " from tb_user"
				  + " where user_id = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		UserVO user = null;
		while (rs.next()) {
			user = new UserVO();
			user.setId(rs.getString("USER_ID"));
			user.setPwd(rs.getString("USER_PWD"));
			user.setName(rs.getString("USER_NAME"));
			user.setPhone(rs.getString("USER_PHONE"));
			user.setAddr(rs.getString("USER_ADDR"));
			user.setPoint(rs.getInt("USER_POINT"));
			user.setRegdate(rs.getDate("USER_REGDATE"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return user;
	}
	
	public void addUser (UserVO user) throws SQLException{ // 회원가입
		String sql = "insert into tb_user (user_id, user_pwd, user_name, user_phone, user_addr)"
				  + " values (?,?,?,?,?)";
		
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getPwd());
		ps.setString(3, user.getName());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getAddr());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	
}
