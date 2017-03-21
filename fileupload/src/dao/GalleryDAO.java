package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.GalleryVO;

public class GalleryDAO {
	
	public void addGallery(GalleryVO gallery) throws SQLException{
		
		String sql = "insert into tb_gallery (no, username, description, filename)"
				+ " values(comm_seq.nextval, ?, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gallery.getUsername());
		ps.setString(2, gallery.getDescription());
		ps.setString(3, gallery.getFilename());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
	
	public ArrayList<GalleryVO> getAllGallery() throws SQLException {
		String sql = "select no, username, description, filename"
				+ " from tb_gallery"
				+ " order by no desc";
		ArrayList<GalleryVO> galleryList = new ArrayList<>();
		GalleryVO gallery = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			gallery = new GalleryVO();
			gallery.setNo(rs.getInt("no"));
			gallery.setUsername(rs.getString("username"));
			gallery.setDescription(rs.getString("description"));
			gallery.setFilename(rs.getString("filename"));
			galleryList.add(gallery);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return galleryList;
	}
}
