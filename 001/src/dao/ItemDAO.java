package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.CartVO;
import vo.ItemVO;
import vo.UserVO;

public class ItemDAO {
	
	static final String CART_VEIW = "select a.USER_NO,a.USER_BIRTHDAY, a.USER_NAME, a.USER_ID, a.USER_PWD, a.USER_PHONE, a.USER_ADDRESS, a.USER_GRADE, a.USER_TOTAL_POINT, a.USER_POINT,a.USER_REGDATE, b.CART_NO, b.CART_REGDATE, b.CART_COUNT, c.ITEM_NO, c.ITEM_CATEGORY_NO, c.ITEM_VIEWSRC, c.ITEM_NAME, c.ITEM_SRC, c.ITEM_COUNT, c.ITEM_PRICE, c.ITEM_ETC, c.ITEM_COLOR, c.ITEM_SIZE, c.ITEM_GROUP_NO"
								 + " from MALL_USER a,MALL_CART b,MALL_ITEM c"
								 + " where a.USER_NO = b.CART_USER_NO"
								 + " and c.ITEM_NO = b.CART_ITEM_NO";
	
	public ArrayList<CartVO> testCart() throws SQLException{
		
		ArrayList<CartVO> cartList = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(CART_VEIW);
		ResultSet rs = ps.executeQuery();
		ItemVO item = null;
		CartVO cart = null;
		UserVO user = null;
		
		while (rs.next()) {
			
			user = new UserVO();
			cart = new CartVO();
			item = new ItemVO();
			item.setItemNo(rs.getInt("ITEM_NO"));
			item.setItemCategoryNo(rs.getInt("ITEM_CATEGORY_NO"));
			item.setItemViewSrc(rs.getString("ITEM_VIEWSRC"));
			item.setItemName(rs.getString("ITEM_NAME"));
			item.setItemSrc(rs.getString("ITEM_SRC"));
			item.setItemCount(rs.getInt("ITEM_COUNT"));
			item.setPrice(rs.getInt("ITEM_PRICE"));
			item.setColor(rs.getString("ITEM_COLOR"));
			item.setSize(rs.getString("ITEM_SIZE"));
			item.setItemGroupNo(rs.getInt("ITEM_GROUP_NO"));
			item.setItemEtc(rs.getString("ITEM_ETC"));
			user.setUserNo(rs.getInt("USER_NO"));
			user.setUserBirth(rs.getString("USER_BIRTHDAY"));
			user.setUserName(rs.getString("USER_NAME"));
			user.setUserId(rs.getString("USER_ID"));
			user.setUserPwd(rs.getString("USER_PWD"));
			user.setUserPhone(rs.getString("USER_PHONE"));
			user.setUserAdd(rs.getString("USER_ADDRESS"));
			user.setGrade(rs.getString("USER_GRADE"));
			user.setUserTotalPoint(rs.getInt("USER_TOTAL_POINT"));
			user.setUserPoint(rs.getInt("USER_POINT"));
			user.setUserRegdate(rs.getDate("USER_REGDATE"));
			cart.setItem(item);
			cart.setUser(user);
			
			cartList.add(cart);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return cartList;
	}
}
