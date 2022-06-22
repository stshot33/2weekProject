package routine.fwd.dao;

import java.util.List;

import routine.fwd.vo.ExVo;

public interface ExDao {

	public String target(int target) throws Exception;
	
	public List<ExVo> allEx(int target) throws Exception;
}
