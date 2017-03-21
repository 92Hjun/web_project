package app;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import mapper.Mapper;
import vo.EmployeeVO;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		Mapper map = new Mapper();
		SqlMapClient sqlMapper = map.getSqlMapper();
		
		List<EmployeeVO> empList = sqlMapper.queryForList("searchEmployeeForSalary", 7000);
		System.out.println(empList);
		
		List<String> empNames = sqlMapper.queryForList("searchEmployeeForDepartmentId", 100);
		
		System.out.println(empNames);
		
		int sumSalary = (Integer)sqlMapper.queryForObject("searchEmployeeForDepartmetIdSumSalary", 70);
		
		System.out.println(sumSalary);
		
		int empCount = (Integer)sqlMapper.queryForObject("searchEmployeeForCount", "SA_MAN");
		System.out.println(empCount);
		
		EmployeeVO employee2 = (EmployeeVO)sqlMapper.queryForObject("searchEmployeeForEmployees", 100);
		System.out.println(employee2);
		
		List<String> empList2 = sqlMapper.queryForList("searchEmployeeForName", "Steven");
		
		System.out.println(empList2);
	}
}
