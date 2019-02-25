package com.example.spring04.model.memo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.spring04.model.memo.dto.MemoDTO;

@Repository
public class MemoDAOImpl implements MemoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	String COLLECTION_NAME="memo";
	
	@Override
	public List<MemoDTO> getMemoList() {
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC, "post_date"));
		return (List<MemoDTO>)mongoTemplate.find(
				query, MemoDTO.class, COLLECTION_NAME);
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		dto.setPost_date(new Date()); //java.util.Date
		// insert( 추가할객체, 컬렉션이름 )
		mongoTemplate.insert(dto, COLLECTION_NAME);
	}

	@Override
	public MemoDTO memoDetail(String _id) {
		//레코드 1개를 찾을 경우 findById(_id, 클래스, 테이블이름)
		return mongoTemplate.findById(
				_id, MemoDTO.class, COLLECTION_NAME);
	}

	@Override
	public void memoUpdate(MemoDTO dto) {
		// update 테이블 set 필드=값, 필드=값 where 필드=값
		// where 조건
		Query query=new Query(
				new Criteria("_id").is(dto.get_id()));
		//수정할 내용
		Update update=new Update();
		update.set("writer", dto.getWriter());
		update.set("memo", dto.getMemo());
		// upsert : update or insert 
		mongoTemplate.upsert(
				query, update, MemoDTO.class, COLLECTION_NAME);
	}

	@Override
	public void memoDelete(String _id) {
		Query query=new Query(new Criteria("_id").is(_id));
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

}







