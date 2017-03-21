package mapper;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Mapper {
	public SqlMapClient getSqlMapper()throws Exception {
		// SqlMapConfig.xml 파일 읽어오기
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		// sqlMapClient 객체 만들기
		SqlMapClient sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		
		return sqlMapper;
	}
}
