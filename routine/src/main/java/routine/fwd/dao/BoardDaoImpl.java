package routine.fwd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.BoardMapper;
import routine.fwd.vo.AnswerVo;
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
	public List<ExBoardVo> allexBoard(int diff) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		return mapper.boardlist(diff);			
	}

	@Override
	public void lookPlus(int no) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		mapper.lookPlus(no);
	}

	@Override
	public ExBoardVo detail(int no) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		return mapper.detail(no);
	}

	@Override
	public List<AnswerVo> allAnswer(int no) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		return mapper.allAnswer(no);
	}

	@Override
	public void addAnswer(AnswerVo answerVo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		mapper.addAnswer(answerVo);
	}

	@Override
	public List<ExBoardVo> recent(int diff) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		return mapper.recent(diff);
	}

}
