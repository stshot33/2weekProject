package routine.fwd.service;

import routine.fwd.vo.MemberVo;

public interface DietMapper {
	
	public MemberVo calculator(MemberVo memberVo) throws Exception;
}
