package routine.fwd.dao;

import java.util.List;

import routine.fwd.vo.ExVo;
import routine.fwd.vo.MemberVo;
import routine.fwd.vo.RoutineVo;

public interface DietDao {
	
	public MemberVo calculator(MemberVo memberVo) throws Exception;
	
	public List<ExVo> routineDivision(RoutineVo routineVo) throws Exception;
}
