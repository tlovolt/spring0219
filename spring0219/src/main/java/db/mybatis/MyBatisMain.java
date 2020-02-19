package db.mybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.mybatis.dao.GoodDao;
import db.mybatis.domain.Good;

public class MyBatisMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");

		//id 없이 자료형만으로 bean을 찾아오기
		GoodDao dao = context.getBean(GoodDao.class);

		//전체 데이터를 가져오는 메소드를 호출해서 확인
		/*
		//List를 리턴하는 경우는 데이터가 없으면 List는 만들고 size가 0
		List<Good> list = dao.allGood();
		for(Good good : list) {
			System.out.println(good);
		}
		 */

		//code를 1개의 데이터를 리턴받는 메소드를 호출
		//1개의 행을 리턴하는 메소드는 리턴할 데이터가 있으면 데이터를 리턴하고
		//없으면 null을 리턴합니다.
		/*
		Good good = dao.detailGood(11);
		System.err.println(good);
		 */

		//삽입하는 메소드 호출
		/*
		Good good = new Good();
		good.setCode(100);
		good.setName("감귤");
		good.setManufacture("제주");
		good.setPrice(300);

		try {
			int result = dao.insertGood(good);
			if(result > 0) {
				System.out.println("데이터 삽입 성공");
			}
		}catch(Exception e) {
			System.out.println("데이터 삽입 성공");
			System.out.println(e.getMessage());
		}
		*/
		
		/*
		Good good = new Good();
		good.setCode(1001);
		good.setName("감자");
		good.setManufacture("고성");
		good.setPrice(3050);

		try {
			int result = dao.updateGood(good);
			if(result > 0) {
				System.out.println("데이터 수정 성공");
			}else {
				System.out.println("수정할 데이터가 없음");
			}
		}catch(Exception e) {
			System.out.println("데이터 수정 실패");
			System.out.println(e.getMessage());
		}
		*/

		try {
			int result = dao.deleteGood(1);
			if(result > 0) {
				System.out.println("데이터 삭제 성공");
			}else {
				System.out.println("삭제할 데이터가 없음");
			}
		}catch(Exception e) {
			System.out.println("데이터 삭제 실패");
			System.out.println(e.getMessage());
		}
		context.close();
	}

}





