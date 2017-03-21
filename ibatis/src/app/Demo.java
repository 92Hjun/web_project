package app;

import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.UserVO;

public class Demo {
	
	public static void main(String[] args) throws Exception{
		
		// SqlMapConfig.xml 파일 읽어오기
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		// sqlMapClient 객체 만들기
		SqlMapClient sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		
		sqlMapper.delete("deleteAllUser");
		
		UserVO user = new UserVO();
		user.setId("hong");
		user.setPwd("ss");
		user.setName("홍길동");
		user.setPhone("010-2345-6778");
		user.setPoint(200);
		user.setAddr("경기");
		user.setRegdate(new Date());
		
		sqlMapper.insert("addNewUser", user);
		
		UserVO user2 = new UserVO();
		user2.setId("jang");
		user2.setPwd("rr");
		user2.setName("장");
		user2.setPhone("010-2345-6778");
		user2.setPoint(300);
		user2.setAddr("서울");
		user2.setRegdate(new Date());
		
		sqlMapper.insert("addNewUser", user2);
		
		List<String> User = sqlMapper.queryForList("getAllUser");
		
		System.out.println("모든 회원의 이름" + User);
			
		
		
		String name = (String)sqlMapper.queryForObject("getUserNameById", "hong");
		
		System.out.println("조회된 이름 : " + name);
		
		int userCount = (Integer)sqlMapper.queryForObject("getUserCount");
		
		System.out.println(userCount);
		
		UserVO User2 = (UserVO)sqlMapper.queryForObject("getUserById", "hong");
		
		System.out.println(User2.getId()+", "+User2.getName()+", "+User2.getPhone()+", "+User2.getAddr());
		
		
		List<UserVO> userList = sqlMapper.queryForList("getAllUsers");
		
		for (UserVO user3 : userList) {
			
			System.out.println(user3.getId()+", "+user3.getName()+", "+user3.getPhone()+", "+user3.getAddr());
			
		}
		
		HashMap<String, Object> map = (HashMap<String, Object>)sqlMapper.queryForObject("getUserByIdForMap", "hong");
		
		System.out.println(map.get("USER_NAME"));
		System.out.println(map.get("USER_ID"));
		System.out.println(map.get("USER_PHONE"));
	}
	
}
