package db.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import db.mybatis.domain.Good;

public interface GoodDao {
	//goods 테이블의 전체 데이터를 가져오는 메소드
	@Select("select * from goods")
	public List<Good> allGood();
	
	//code를 가지고 goods 테이블에서 데이터를 조회하는 메소드
	//code는 기본키
	@Select("select * from goods where code = #{code}")
	public Good detailGood(int code);
	
	//데이터를 추가하는 메소드
	@Insert("insert into goods(code, name, manufacture, price) "
			+ "values(#{code}, #{name}, #{manufacture} , #{price})")
	public int insertGood(Good good);
	
	//데이터를 수정하는 메소드
	@Update("update goods set name=#{name}, "
			+ "manufacture=#{manufacture}, price=#{price} "
			+ "where code = #{code}")
	public int updateGood(Good good);
	
	//데이터를 삭제하는 메소드
	@Delete("delete from goods "
			+ "where code = #{code}")
	public int deleteGood(int code);
}












