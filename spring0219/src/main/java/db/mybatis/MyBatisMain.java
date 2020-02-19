package db.mybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.mybatis.dao.GoodDao;
import db.mybatis.domain.Good;
import db.mybatis.service.GoodService;

public class MyBatisMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
		//삽입할 데이터 생성
		Good good = new Good();
		good.setCode(102);
		good.setName("무화과");
		good.setManufacture("목포");
		good.setPrice(3000);
		
		//GoodService 객체 가져오기
		GoodService service = context.getBean(GoodService.class);
		//메소드 호출
		service.insertGood(good);

		context.close();
	}

}





