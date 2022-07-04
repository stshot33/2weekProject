package routine.fwd.service;

import routine.fwd.vo.FoodVo;
import routine.fwd.vo.MemberVo;

public interface DietMapper {
	
	public void calculator(MemberVo memberVo) throws Exception;
	
	public FoodVo mainTan();
	
	public FoodVo mainDan();
	
	public FoodVo mainZi();
}
