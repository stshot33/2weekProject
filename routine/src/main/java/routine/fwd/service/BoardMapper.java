package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.AnswerVo;
import routine.fwd.vo.ExBoardVo;

public interface BoardMapper {
	
	public void exboardInsert(ExBoardVo exBoardVo);
	
	public List<ExBoardVo> boardlist(int diff);
	
	public List<ExBoardVo> recent(int diff);
	
	public void lookPlus(int no);
	
	public ExBoardVo detail(int no);
	
	public List<AnswerVo> allAnswer(int no);
	
	public void addAnswer(AnswerVo answerVo);
}
