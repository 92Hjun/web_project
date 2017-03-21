package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class BoardDAO {
	static final String sql = "select *"
						   + " from tb_board";
	static final String getByNo = "select *"
							   + " from tb_board"
							   + " where no = ?";
	static final String serchUser = "select *"
								 + " from tb_board"
								 + " where id = ?"
								 + " and pwd = ?";
	public ArrayList<BoardVO> getBoardList () throws SQLException{
		ArrayList<BoardVO> boardList = new ArrayList<>();
		BoardVO board = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setLikes(rs.getInt("likes"));
			board.setContents(rs.getString("contents"));
			board.setDate(rs.getDate("regdate"));
			boardList.add(board);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return boardList;
	}
	
	public BoardVO getBoardDetailByNo (int no) throws SQLException{
		BoardVO board = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(getByNo);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setLikes(rs.getInt("likes"));
			board.setContents(rs.getString("contents"));
			board.setDate(rs.getDate("regdate"));
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		return board;
	}
	
}
