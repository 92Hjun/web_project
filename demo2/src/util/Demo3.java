package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo3 {
	public static void main(String[] args)throws Exception{
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select count(*) cnt from employees");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			System.out.println("행의 갯수: " + rs.getInt("cnt"));
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}
}
