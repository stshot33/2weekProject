package routine.fwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.BoardDao;
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
	public List<ExBoardVo> allexBoard() {
		
		return boardDao.allexBoard();
	}

}
