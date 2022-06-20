package routine.fwd.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.TestMapper;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int test() throws Exception {
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		System.out.println("dao");
		
		return mapper.test();
	}

	@Override
	public String test2() throws Exception {
		
		String msg = "dao";
		
		return msg;
	}
}
