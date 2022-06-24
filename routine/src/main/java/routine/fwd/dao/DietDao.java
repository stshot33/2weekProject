package routine.fwd.dao;

import routine.fwd.vo.MemberVo;

public interface DietDao {
	
	public MemberVo calculator(MemberVo memberVo) throws Exception;
}
