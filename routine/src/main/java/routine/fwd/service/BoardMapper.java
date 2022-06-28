package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.ExBoardVo;

public interface BoardMapper {
	
	public void exboardInsert(ExBoardVo exBoardVo);
	
	public List<ExBoardVo> boardlist();
}
