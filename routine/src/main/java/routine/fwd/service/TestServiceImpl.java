package routine.fwd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import routine.fwd.dao.TestDao;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao testDao;
	
	@Override
	public int test() throws Exception {
		System.out.println("Service");
		
		return testDao.test();
	}

	@Override
	public String test2() throws Exception {
		System.out.println("service");
		return testDao.test2();
	}

}
