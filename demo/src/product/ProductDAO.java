package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class ProductDAO {
	public ArrayList<ProductVO> getAllProduct() throws SQLException{
		ArrayList<ProductVO> productList = new ArrayList<>();
		
		String sql = "select *"
				+ " from TB_PRODUCT"
				+ " order by no desc";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductVO product = new ProductVO();
			product.setNo(rs.getInt("no"));
			product.setName(rs.getString("name"));
			product.setProcount(rs.getInt("procount"));
			productList.add(product);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return productList;
	}
	
	public void deleteProduct (int no) throws SQLException {
		String sql = "delete from tb_product where no = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
}
