package db.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.hibernate.domain.Good;

//bean 생성을 자동을 해주는 어노테이션
@Repository
public class GoodDao {
	//하이버네이트 사용 변수 생성
	@Autowired
	private SessionFactory sessionFactory;
	
	//데이터 삽입하는 메소드
	@Transactional
	public int insertGood(Good good) {
		sessionFactory.getCurrentSession().save(good);
		return 1;
	}
	
	//데이터 수정하는 메소드
	@Transactional
	public void updateGood(Good good) {
		sessionFactory.getCurrentSession().update(good);
	}
	
	//데이터 삭제하는 메소드
	@Transactional
	public void deleteGood(Good good) {
		sessionFactory.getCurrentSession().delete(good);
	}
}







