package routine.fwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.MemberDao;
import routine.fwd.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	public void saveInfo(MemberVo memberVo) throws Exception {
		
		if(memberDao.selectId(memberVo) == 0) {
			memberDao.saveInfo(memberVo);
		}else {
			System.out.println("이미 있는 아이디");
		}
	}
}