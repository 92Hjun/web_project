package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class StudentDAO {
	static final String addStudent = "INSERT INTO TB_STUDENT (NO, NAME, MAJOR, GRADE, PHONE) VALUES (SCHOOL_SEQ.NEXTVAL,?,?,?,?)";
	
	static final String serchStudentByGrade = "select * from tb_student where grade = ?";
	
	
	public void addStudent(String name,String major,int grade, String phone) throws SQLException{
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(addStudent);
		ps.setString(1, name);
		ps.setString(2, major);
		ps.setInt(3, grade);
		ps.setString(4, phone);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public ArrayList<StudentVo> serchStudentByGrade (int grade) throws SQLException{
		ArrayList<StudentVo> studentList = new ArrayList<>();
		StudentVo student = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(serchStudentByGrade);
		ps.setInt(1, grade);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			student = new StudentVo();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setMajor(rs.getString("major"));
			student.setGrade(rs.getInt("grade"));
			student.setPhone(rs.getString("phone"));
			studentList.add(student);
		}
		rs.close();
		ps.close();
		con.close();
		
		
		return studentList;
	}
}
