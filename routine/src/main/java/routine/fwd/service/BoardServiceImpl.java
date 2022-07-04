package routine.fwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.BoardDao;
import routine.fwd.vo.AnswerVo;
import routine.fwd.vo.ExBoardVo;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;
	
	@Override
	public void exboardInsert(ExBoardVo exboardVo) {
		
		boardDao.exboardInsert(exboardVo);
		
	}

	@Override
	public List<ExBoardVo> allexBoard(int diff) {
		
		return boardDao.allexBoard(diff);
	}

	@Override
	public void lookPlus(int no) {
		
		boardDao.lookPlus(no);
	}

	@Override
	public ExBoardVo detail(int no) {

		return boardDao.detail(no);
	}

	@Override
	public List<AnswerVo> allAnswer(int no) {

		return boardDao.allAnswer(no);
	}

	@Override
	public void addAnswer(AnswerVo answerVo) {
		
		boardDao.addAnswer(answerVo);
	}

	@Override
	public List<ExBoardVo> recent(int diff) {

		return boardDao.recent(diff);
	}

}
