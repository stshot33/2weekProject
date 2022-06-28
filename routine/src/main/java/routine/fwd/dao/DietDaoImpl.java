package routine.fwd.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import routine.fwd.service.DietMapper;
import routine.fwd.service.ExMapper;
import routine.fwd.vo.ExVo;
import routine.fwd.vo.MemberVo;
import routine.fwd.vo.RoutineVo;

@Repository
public class DietDaoImpl implements DietDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public MemberVo calculator(MemberVo memberVo) {
		DietMapper mapper = sqlSession.getMapper(DietMapper.class);
		
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
			memberVo.setM_activity(activity);
			memberVo.setM_calorie(calorie);
			
			mapper.calculator(memberVo);
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


	@Override
	public List<ExVo> routineDivision(RoutineVo routineVo) throws Exception {
		List<ExVo> exVoList = new ArrayList<>();
		List<ExVo> returnList = new ArrayList<>();
		int[] ran = new int[2];
		
		if(routineVo.getDivision()==1) {
			int[] t = {1, 4, 5, 2, 6};
			
			for(int i=0; i<t.length; i++) {
				exVoList = exNum(t[i]);
				
				ran = randomNum(2, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			return returnList;
		}else if(routineVo.getDivision()==2) {
			int[] t1 = {1, 4, 5, 2};
			int[] t2 = {6};
			
			for(int i=0; i<t1.length; i++) {
				exVoList = exNum(t1[i]);
				
				ran = randomNum(3, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			for(int i=0; i<t2.length; i++) {
				exVoList = exNum(t2[i]);
				
				ran = randomNum(3, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			return returnList;
		}else {
			int[] t1 = {1, 2};
			int[] t2 = {4, 5};
			int[] t3 = {6};
			
			for(int i=0; i<t1.length; i++) {
				exVoList = exNum(t1[i]);
				
				ran = randomNum(3, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			for(int i=0; i<t2.length; i++) {
				exVoList = exNum(t2[i]);
				
				ran = randomNum(3, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			for(int i=0; i<t3.length; i++) {
				exVoList = exNum(t3[i]);
				
				ran = randomNum(3, exVoList.size());
				
				for(int j=0; j<ran.length; j++) {
					returnList.add(exVoList.get(ran[j]));
				}
			}
			
			return returnList;
		}
	}
	
	// 운동 타겟 번호에 해당하는 모든 운동 정보 가져오기
	private List<ExVo> exNum(int num) throws Exception{
		ExMapper mapper = sqlSession.getMapper(ExMapper.class);
		List<ExVo> exVo = new ArrayList<>();
		
		exVo = mapper.allEx(num);
		
		return exVo;
	}
	
	
	/* 난수 설정
	 * num1 = n 배열의 크기, num2 = 난수의 최대 범위
	 */
    public int[] randomNum(int num1, int num2) {
    	int n[] = new int[num1];
    	Random r = new Random();
    	
    	for(int i=0;i<num1;i++) {
    		n[i] = r.nextInt(num2);
    		for(int j=0;j<i;j++) {
    			if(n[i]==n[j]) {
    				i--;
    			}
    		}
    	}
        
        return n;
    }
}
