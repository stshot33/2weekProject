package routine.fwd.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.BoardMapper;
import routine.fwd.vo.ExBoardVo;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void exboardInsert(ExBoardVo exboardVo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		mapper.exboardInsert(exboardVo);
		
	}

	@Override
	public List<ExBoardVo> allexBoard() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		return mapper.boardlist();			
	}

	
	
}
