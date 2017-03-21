package demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class BoardDAO {
	
	// 새로운 게시글 저장하기
	public void addBoard(String title, String writer, String contents,String ip) throws SQLException{
		String sql = "insert into TB_BOARD (NO, TITLE, WRITER,CONTENTS, ip)"
				  + "  VALUES (board_seq.nextval,?,?,?,?)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, title);
		ps.setString(2, writer);
		ps.setString(3, contents);
		ps.setString(4, ip);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	
	// 등록된 모든 게시글을 제공하기
	public ArrayList<BoardVO> getAllBoards () throws SQLException{
		ArrayList<BoardVO> boardList = new ArrayList<>();
		String sql = "select no,title,regdate "
				  + " from tb_board "
				  + " order by no desc";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			BoardVO board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setRegdate(rs.getDate("regdate"));
			boardList.add(board);
		}
		rs.close();
		ps.close();
		con.close();
		
		return boardList;
	}
	
	
	// 특정 글 번호에 해당하는 게시글을 제공하기
	public BoardVO getBoardByNo (int bno) throws SQLException{
		BoardVO board = null;
		String sql = "select *"
				  + " from tb_board"
				  + " where no = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bno);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setLikes(rs.getInt("likes"));
			board.setContents(rs.getString("contents"));
			board.setRegdate(rs.getDate("regdate"));
			board.setIp(rs.getString("ip"));
			
		}
		return board;
	}
	
	// 특정글 번호에 해당하는 게시글을 삭제하기
	public void deleteBoardByNo (int bno) throws SQLException {
		String sql = "delete from tb_board where no = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, bno);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	// 제목에 특정 단어가 포함된 게시글을 제공하기
	
	// ...
}
