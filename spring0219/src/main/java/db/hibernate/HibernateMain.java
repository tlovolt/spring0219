package db.hibernate;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.hibernate.dao.GoodDao;
import db.hibernate.domain.Good;

public class HibernateMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext(
				"classpath:hibernateContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		Good good = new Good();
		good.setCode(201);

		dao.deleteGood(good);
		
		context.close();
	}

}
