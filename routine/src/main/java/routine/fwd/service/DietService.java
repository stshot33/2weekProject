package routine.fwd.service;

import routine.fwd.vo.MemberVo;

public interface DietService {
	
	public MemberVo calculator(MemberVo memberVo) throws Exception;
	
	public MemberVo callInfo(long id) throws Exception;
}
