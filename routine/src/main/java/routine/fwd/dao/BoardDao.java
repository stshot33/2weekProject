package routine.fwd.dao;

import java.util.List;

import routine.fwd.vo.ExBoardVo;

public interface BoardDao {
	
	public void exboardInsert(ExBoardVo exboardVo);
	
	public List<ExBoardVo> allexBoard();
}
