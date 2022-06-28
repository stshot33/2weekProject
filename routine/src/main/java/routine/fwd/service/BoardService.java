package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.ExBoardVo;

public interface BoardService {
	
	public void exboardInsert(ExBoardVo exboardVo);
	
	public List<ExBoardVo> allexBoard();
}
