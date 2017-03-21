package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class TodoDAO {
	
	static final String ADD_TODO = "insert into tb_todo (NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED)"
			                    + " values (todo_seq.nextval,?,?,?,?,?,'NO')";
	
	static final String SERCH_TODO ="select NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED"
								 + " from tb_todo";
	
	static final String UPDATE_TODO_BY_COMPLETED = "update tb_todo set COMPLETED = 'YES' where no = ?";
	
	static final String DELETE_TODO_BY_NO ="delete from tb_todo where no = ?";
	
	static final String DETAIL_TODOLIST = "select NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED"
			                           + " from tb_todo"
			                           + " where no = ?";
	
	static final String SERCH_TODO_BY_CATEGORY ="select no,category,title,description, day, location, completed, user_id"
			  								  + " from (select row_number() over (order by no desc) rn,"
											  + " 		no,category,title,description, day, location, completed, user_id"
											  + "		from tb_todo"
											  + "		where user_id= ? )"
											  + " where rn >= ? and rn <= ?"
											  + " and category = ?";
	
	static final String TOTAL_ROWS ="select count(*) cnt from tb_todo where user_id = ?";
	
	static final String TODOLIST_FOR_PAGING ="select no,category,title,description, day, location, completed, user_id"
										  + " from (select row_number() over (order by no desc) rn,"
										  + " 		no,category,title,description, day, location, completed, user_id"
										  + "		from tb_todo"
										  + "		where user_id= ? )"
										  + " where rn >= ? and rn <= ?";
	
	public ArrayList<TodoVO> getTodoListForPaging(int begin, int end, String userId) throws Exception {
		ArrayList<TodoVO> todoList = new ArrayList<>();
		
		TodoVO todo = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(TODOLIST_FOR_PAGING);
		ps.setString(1, userId);
		ps.setInt(2, begin);
		ps.setInt(3, end);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			todo = new TodoVO();
			todo.setNo(rs.getInt("NO"));
			todo.setCategory(rs.getString("CATEGORY"));
			todo.setTitle(rs.getString("TITLE"));
			todo.setDescription(rs.getString("DESCRIPTION"));
			todo.setLocation(rs.getString("LOCATION"));
			todo.setDate(rs.getString("DAY"));
			todo.setCompleted(rs.getString("COMPLETED"));
			todoList.add(todo);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		return todoList;
	} 
	
	public int getTotalRows(String userId) throws SQLException { // 리스트 총 갯수 
		int totalRows = 0;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(TOTAL_ROWS);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			totalRows = rs.getInt("cnt");
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		return totalRows;
	}
	
	
	public void addToo (TodoVO todo) throws SQLException{ // todo저장
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(ADD_TODO);
		ps.setString(1, todo.getCategory());
		ps.setString(2, todo.getTitle());
		ps.setString(3, todo.getDescription());
		ps.setString(4, todo.getLocation());
		ps.setString(5, todo.getDate());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
	
	public ArrayList<TodoVO> getTodo () throws SQLException{ //리스트화면
		
		ArrayList<TodoVO> todoList = new ArrayList<>();
		TodoVO todo = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SERCH_TODO);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			todo = new TodoVO();
			todo.setNo(rs.getInt("NO"));
			todo.setCategory(rs.getString("CATEGORY"));
			todo.setTitle(rs.getString("TITLE"));
			todo.setDescription(rs.getString("DESCRIPTION"));
			todo.setLocation(rs.getString("LOCATION"));
			todo.setDate(rs.getString("DAY"));
			todo.setCompleted(rs.getString("COMPLETED"));
			todoList.add(todo);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return todoList;
				
	}
	
	public void updateTodoCompleted (int sno) throws SQLException{ // 완료
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(UPDATE_TODO_BY_COMPLETED);
		ps.setInt(1, sno);
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public void deleteTodoByNo (int dno) throws SQLException { // 삭제
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(DELETE_TODO_BY_NO);
		ps.setInt(1, dno);
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
	}
	
	public TodoVO detailTodo(int detailNo) throws SQLException{ // 디테일뷰
		
		TodoVO todo = null;
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(DETAIL_TODOLIST);
		ps.setInt(1, detailNo);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			todo = new TodoVO();
			todo.setNo(rs.getInt("NO"));
			todo.setCategory(rs.getString("CATEGORY"));
			todo.setTitle(rs.getString("TITLE"));
			todo.setDescription(rs.getString("DESCRIPTION"));
			todo.setLocation(rs.getString("LOCATION"));
			todo.setDate(rs.getString("DAY"));
			todo.setCompleted(rs.getString("COMPLETED"));

		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		return todo;
		
	}
	
	public ArrayList<TodoVO> serchTodoByCategory (int begin, int end, String userId, String category) throws SQLException{
		
		ArrayList<TodoVO> todoList = new ArrayList<>();
		TodoVO todo = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SERCH_TODO_BY_CATEGORY);
		ps.setString(1, userId);
		ps.setInt(2, begin);
		ps.setInt(3, end);
		ps.setString(4, category);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			todo = new TodoVO();
			todo.setNo(rs.getInt("NO"));
			todo.setCategory(rs.getString("CATEGORY"));
			todo.setTitle(rs.getString("TITLE"));
			todo.setDescription(rs.getString("DESCRIPTION"));
			todo.setLocation(rs.getString("LOCATION"));
			todo.setDate(rs.getString("DAY"));
			todo.setCompleted(rs.getString("COMPLETED"));
			todoList.add(todo);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return todoList;
	}
}
