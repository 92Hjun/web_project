package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class UserDAO {
	static final String SERCH_USER_BY_ID ="select USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_ADDR, USER_POINT, USER_REGDATE"
									   + " from tb_user"
									   + " where USER_ID = ?";
	public UserVO serchUserById (String id) throws SQLException {
		UserVO user = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SERCH_USER_BY_ID);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			user = new UserVO();
			user.setUserid(rs.getString("USER_ID"));
			user.setUserpwd(rs.getString("USER_PWD"));
			user.setName(rs.getString("USER_NAME"));
			user.setPhone(rs.getString("USER_PHONE"));
			user.setAddr(rs.getString("USER_ADDR"));
		}
		
		return user;
		
	}
}
