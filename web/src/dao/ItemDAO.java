package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.CartVO;
import vo.ItemVO;

public class ItemDAO {
	
	public ArrayList<ItemVO> getAllItems() throws SQLException {
		String sql = "select ITEM_NO, ITEM_NAME, ITEM_MAKER, ITEM_PRICE, ITEM_PUBDATE"
				+ " from tb_item"
				+ " order by item_no asc";
		ArrayList<ItemVO> itemList = new ArrayList<>();
		ItemVO item = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			item = new ItemVO();
			item.setNo(rs.getInt("ITEM_NO"));
			item.setName(rs.getString("ITEM_NAME"));
			item.setMaker(rs.getString("ITEM_MAKER"));
			item.setPrice(rs.getInt("ITEM_PRICE"));
			item.setPubdate(rs.getDate("ITEM_PUBDATE"));
			
			itemList.add(item);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return itemList;
		
	}

	public void addCart(String userId,int itemNo) throws SQLException{
		String sql = "insert into tb_cart(CART_NO, ITEM_NO, USER_ID, REGDATE)"
				+ " values(comm_seq.nextval,?,?,sysdate)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, itemNo);
		ps.setString(2, userId);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public ArrayList<CartVO> getCartItemsByUser (String userId)throws SQLException {
		String sql = "select A.cart_no,B.item_no,B.item_name,B.item_maker,B.item_price,A.regdate"
				+ " from tb_cart A, tb_item B "
				+ " where A.item_no = B.item_no"
				+ " and A.user_id = ?";
		ArrayList<CartVO> cartList = new ArrayList<>();
		CartVO cart = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			cart = new CartVO();
			cart.setNo(rs.getInt("CART_NO"));
			cart.setRegdate(rs.getDate("REGDATE"));
			
			ItemVO item = new ItemVO();
			item.setNo(rs.getInt("ITEM_NO"));
			item.setName(rs.getString("ITEM_NAME"));
			item.setMaker(rs.getString("ITEM_MAKER"));
			item.setPrice(rs.getInt("ITEM_PRICE"));
			
			cart.setItem(item);
			
			cartList.add(cart);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return cartList;
	}
	
	public void deleteCartItemByNo (int cartNo) throws SQLException {
		String sql = "delete from tb_cart where cart_no = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cartNo);
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
}