package routine.fwd.service;

import java.util.List;

import routine.fwd.vo.ExVo;

public interface ExService {
	
	public String target(int target) throws Exception;
	
	public List<ExVo> allEx(int target) throws Exception;
}
