package routine.fwd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.MemberMapper;
import routine.fwd.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public MemberVo selectInfo(MemberVo membervo) throws Exception{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		return mapper.selectInfo(membervo);
	}
	
	@Override
	public int selectId(MemberVo memberVo) throws Exception {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		return mapper.selectId(memberVo);
	}
	
	@Override
	public void saveInfo(MemberVo memberVo) throws Exception {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		mapper.saveInfo(memberVo);
	}

}
