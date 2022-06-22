package routine.fwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.ExDao;
import routine.fwd.vo.ExVo;

@Service
public class ExServiceImpl implements ExService {
	
	@Autowired
	ExDao exDao;

	@Override
	public String target(int target) throws Exception {
		return exDao.target(target);
	}

	@Override
	public List<ExVo> allEx(int target) throws Exception {
		return exDao.allEx(target);
	}
}
