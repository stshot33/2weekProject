package routine.fwd.service;

import routine.fwd.vo.MemberVo;

public interface MemberMapper {

	public MemberVo selectInfo(MemberVo memberVo) throws Exception;
	
	public int selectId(MemberVo memberVo) throws Exception;
	
	public void saveInfo(MemberVo memberVo) throws Exception;
}
