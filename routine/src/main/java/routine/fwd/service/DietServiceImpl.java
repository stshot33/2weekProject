package routine.fwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.DietDao;
import routine.fwd.dao.MemberDao;
import routine.fwd.vo.ExVo;
import routine.fwd.vo.MemberVo;
import routine.fwd.vo.RoutineVo;

@Service
public class DietServiceImpl implements DietService{

	@Autowired
	DietDao dietDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public MemberVo calculator(MemberVo memberVo) throws Exception {
		
		return dietDao.calculator(memberVo);
	}

	@Override
	public MemberVo callInfo(long id) throws Exception {
		MemberVo memberVo = new MemberVo();
		memberVo.setM_id(id);
		
		return memberDao.selectInfo(memberVo);
	}

	@Override
	public List<ExVo> routineDivision(RoutineVo routineVo) throws Exception {
			return dietDao.routineDivision(routineVo);
	}

}
