package routine.fwd.dao;

import java.util.List;

import routine.fwd.vo.AnswerVo;
import routine.fwd.vo.ExBoardVo;

public interface BoardDao {
	
	public void exboardInsert(ExBoardVo exboardVo);
	
	public List<ExBoardVo> allexBoard(int diff);
	
	public List<ExBoardVo> recent(int diff);
	
	public void lookPlus(int no);
	
	public ExBoardVo detail(int no);
	
	public List<AnswerVo> allAnswer(int no);
	
	public void addAnswer(AnswerVo answerVo);
}
