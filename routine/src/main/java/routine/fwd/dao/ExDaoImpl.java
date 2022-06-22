package routine.fwd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.ExMapper;
import routine.fwd.vo.ExVo;

@Repository
public class ExDaoImpl implements ExDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public String target(int target) throws Exception {
		ExMapper mapper = sqlSession.getMapper(ExMapper.class);
		return mapper.target(target);
	}

	@Override
	public List<ExVo> allEx(int target) throws Exception {
		ExMapper mapper = sqlSession.getMapper(ExMapper.class);
		return mapper.allEx(target);
	}
}
