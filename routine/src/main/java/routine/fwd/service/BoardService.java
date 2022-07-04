package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.AnswerVo;
import routine.fwd.vo.ExBoardVo;

public interface BoardService {
	
	public void exboardInsert(ExBoardVo exboardVo);
	
	public List<ExBoardVo> allexBoard(int diff);
	
	// 최신 글 10개 조회
	public List<ExBoardVo> recent(int diff);
	
	// 조회수 증가 업데이트
	public void lookPlus(int no);
	
	public ExBoardVo detail(int no);
	
	// 게시물에 해당하는 모든 댓글 가져오기
	public List<AnswerVo> allAnswer(int no);
	
	// 댓글 추가
	public void addAnswer(AnswerVo answerVo);
}
