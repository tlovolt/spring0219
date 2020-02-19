package db.hibernate.dao;

import java.util.List;

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
	
	//테이블의 데이터를 전부 가져오는 메소드
	@Transactional
	public List<Good> allGood(){
		//Good 클래스와 연결된 테이블의 모든 데이터 찾아오기
		//return sessionFactory.getCurrentSession().createCriteria(Good.class).list();
		
		//SQL을 이용해서 데이터 가져오기
		//메소드의 리턴 값을 가지고 다른 메소드를 호출하는 것을
		//메소드 체이닝이라고 합니다.
		//변수를 만들지 않고 메소드 호출을 처리하기 위해서 사용
		return sessionFactory
				.getCurrentSession()
				.createSQLQuery("select * from goods")
				.addEntity(Good.class)
				.getResultList();
	}
	
	//code를 가지고 하나의 행을 찾아오는 메소드
	@Transactional
	public Good getGood(int code){
		return sessionFactory.getCurrentSession()
				.get(Good.class, code);
	}
}







