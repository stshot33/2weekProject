package routine.fwd.dao;

import routine.fwd.vo.MemberVo;

public interface MemberDao {
	
	public MemberVo selectInfo(MemberVo membervo) throws Exception;
	
	public int selectId(MemberVo memberVo) throws Exception;
	
	public void saveInfo(MemberVo memberVo) throws Exception;
}
