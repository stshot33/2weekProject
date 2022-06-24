package routine.fwd.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.DietMapper;
import routine.fwd.vo.MemberVo;

@Repository
public class DietDaoImpl implements DietDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public MemberVo calculator(MemberVo memberVo) {
		
		try {
			int activity = activity(memberVo.getM_activity());
			int goal = memberVo.getM_goal();
			float height = (memberVo.getM_height() - 100);
			float calorie = (float) (height * 0.9) * activity;
			
			if(memberVo.getM_sex()==2) calorie -= 300;
			
			if(goal==1) calorie += 500;
			if(goal==3) calorie -= 500; 
			
			memberVo.setM_calorie(calorie);
			
			int dan = (int)(memberVo.getM_weight() * 8);
			int zi = (int)(calorie * 0.2);
			int tan = (int)(calorie - (dan+zi));
			
			memberVo.setTan(tan);
			memberVo.setDan(dan);
			memberVo.setZi(zi);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberVo;
	}

	
	private int activity(int activity) {
		
		int act = 0;
		
		if(activity==1) act=25;
		if(activity==2) act=30;
		if(activity==3) act=35;
		if(activity==4) act=40;
		
		return act;
	}
}
