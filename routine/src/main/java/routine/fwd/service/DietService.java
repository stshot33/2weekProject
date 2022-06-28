package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.ExVo;
import routine.fwd.vo.MemberVo;
import routine.fwd.vo.RoutineVo;

public interface DietService {
	
	public MemberVo calculator(MemberVo memberVo) throws Exception;
	
	public MemberVo callInfo(long id) throws Exception;
	
	public List<ExVo> routineDivision(RoutineVo routineVo) throws Exception;
}
