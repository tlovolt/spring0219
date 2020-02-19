package db.hibernate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.hibernate.dao.GoodDao;
import db.hibernate.domain.Good;

public class HibernateMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext(
				"classpath:hibernateContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		
		List<Good> list = dao.allGood();
		for(Good good : list) {
			System.err.println(good);
		}
		
		
		Good good = dao.getGood(2);
		System.out.println(good);
		
		
		context.close();
	}

}
