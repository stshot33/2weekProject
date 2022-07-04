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
import routine.fwd.vo.FoodVo;
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
			
			memberVo.setM_tan(tan);
			memberVo.setM_dan(dan);
			memberVo.setM_zi(zi);
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


	@Override
	public List<FoodVo> diet(MemberVo memberVo) {
		DietMapper mapper = sqlSession.getMapper(DietMapper.class);
		List<FoodVo> foodList = new ArrayList<>();
		List<Integer> kcal = new ArrayList<>();
		FoodVo foodVo = new FoodVo();
		int nth = 0;
		
		// 탄수화물 계산
		foodVo = mapper.mainTan();

		nth = dietCalorie(foodVo, memberVo, 1, kcal);
		kcal = tkcalMinus(nth, foodVo, memberVo);
		
		foodVo.setF_once(100 * nth);
		
		foodList.add(0, foodVo);
		
		// 단백질 계산
		for(int i=1; i<3; i++) {
			if(i==1) foodVo = mapper.mainDan();
			if(i==2) foodVo = mapper.mainZi();
			
			nth = dietCalorie(foodVo, memberVo, i+1, kcal);
			kcal = dzkcalMinus(nth, foodVo, kcal);
			
			if(foodVo.getF_name().equals("아몬드")) {
				foodVo.setF_once(30 * nth);
			}else {
				foodVo.setF_once(100 * nth);
			}
			
			foodList.add(i, foodVo);
		}
		
		return foodList;
	}
	
	// 탄단지 얼마나 먹어야 하는지 계산
	private int dietCalorie(FoodVo foodVo, MemberVo memberVo, int tdz, List<Integer> totalKcal) {
		int kcal = 0;
		int total = 0;
		
		if(tdz == 1) {
			kcal = foodVo.getF_tan();
			total = memberVo.getM_tan()/4;
		}else if(tdz == 2) {
			kcal = foodVo.getF_dan();
			total = totalKcal.get(2);
		}else if(tdz == 3){
			kcal = foodVo.getF_zi();
			total = totalKcal.get(3);
		}
		
		return total/kcal;
	}
	
	// 탄수화물 칼로리 계산
	private List<Integer> tkcalMinus(int nth, FoodVo foodVo, MemberVo memberVo) {
		List<Integer> kcal = new ArrayList<>();
		kcal.add((int) (memberVo.getM_calorie() - (foodVo.getF_once()*nth)));
		kcal.add((int) ((memberVo.getM_tan()/4) - (foodVo.getF_tan()*nth)));
		kcal.add((int) ((memberVo.getM_dan()/4) - (foodVo.getF_dan()*nth)));
		kcal.add((int) ((memberVo.getM_zi()/9) - (foodVo.getF_zi()*nth)));
		
		return kcal;
	}
	
	// 단백질/지방 칼로리 계산
	private List<Integer> dzkcalMinus(int nth, FoodVo foodVo, List<Integer> kcal) {
		kcal.set(0,(int) (kcal.get(0) - (foodVo.getF_once()*nth)));
		kcal.set(1,(int) (kcal.get(1) - (foodVo.getF_tan()*nth)));
		kcal.set(2,(int) (kcal.get(2) - (foodVo.getF_dan()*nth)));
		kcal.set(3,(int) (kcal.get(3) - (foodVo.getF_zi()*nth)));
		
		return kcal;
	}
}