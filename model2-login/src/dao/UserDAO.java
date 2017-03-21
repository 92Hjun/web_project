package dao;

import java.sql.SQLException;
import java.util.List;


import util.SqlMapperUtil;
import vo.UserVO;

public class UserDAO {
	
	public void changeUserStateY(String userId) throws SQLException {
		SqlMapperUtil.getSqlMapper().update("changeUserStateY", userId);
	}
	public void changeUserStateN(String userId) throws SQLException {
		SqlMapperUtil.getSqlMapper().update("changeUserStateN", userId);
	}
	
	public void addNewUser(UserVO user) throws SQLException {
		SqlMapperUtil.getSqlMapper().insert("addNewUser", user);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserVO> getAllUsers() throws SQLException {
		return SqlMapperUtil.getSqlMapper().queryForList("getAllUsers");
	}
	
	public UserVO getUserById(String userId) throws SQLException{
		return (UserVO) SqlMapperUtil.getSqlMapper().queryForObject("getUserById", userId);
	}
	
}
