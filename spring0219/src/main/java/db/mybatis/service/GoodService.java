package db.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.mybatis.dao.GoodDao;
import db.mybatis.domain.Good;

//이 클래스의 bean은 자동 생성
@Service
public class GoodService {
	//동일한 자료형의 bean이 있으면 자동으로 주입해주는 어노테이션
	@Autowired
	private GoodDao goodDao;
	
	//데이터를 삽입하는 메소드
	public int insertGood(Good good) {
		//동일한 데이터를 2번 삽입 - 예외발생
		goodDao.insertGood(good);
		return goodDao.insertGood(good);
	}
	
}








