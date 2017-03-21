package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class UserDAO {
	
	public UserVO getUserIdPwd (String id, String pwd) throws SQLException{
		UserVO user = new UserVO();
		String sql = "select *"
				  + " from TB_USER"
				  + " where ID = ?"
				  + " AND PWD = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user.setId(rs.getString("ID"));
			user.setPwd(rs.getString("pwd"));
			
		}
		rs.close();
		ps.close();
		con.close();
		
		return user;
	}
}
