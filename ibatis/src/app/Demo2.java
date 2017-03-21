package app;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import mapper.Mapper;
import vo.EmployeeVO;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		
		Mapper mapper = new Mapper();
		SqlMapClient sqlMapper = mapper.getSqlMapper();
		
		
		EmployeeVO emp = new EmployeeVO();
		
		emp.setDepartmentId(60);
		//emp.setSalary(1000);
		//emp.setJobId("SA_MAN");
		
		List<EmployeeVO> employees = sqlMapper.queryForList("searchEmployees", emp);
		
		System.out.println(employees);
	}
}
