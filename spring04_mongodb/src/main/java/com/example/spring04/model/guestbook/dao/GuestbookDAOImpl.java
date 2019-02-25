package com.example.spring04.model.guestbook.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.spring04.model.guestbook.dto.GuestbookDTO;
@Repository //dao bean
public class GuestbookDAOImpl implements GuestbookDAO {

	@Autowired 
	MongoTemplate mongoTemplate; //mongodb 실행 객체
	
	String COLLECTION_NAME="guestbook"; //컬렉션(테이블) 이름
	
	@Override
	public List<GuestbookDTO> getArticleList() {
		Query query=new Query();
		query.with(new Sort(Sort.Direction.DESC, "post_date"));
		List<GuestbookDTO> list=
				(List<GuestbookDTO>)mongoTemplate.find(
				query, GuestbookDTO.class, COLLECTION_NAME);
		for(GuestbookDTO dto : list) {
			String content=dto.getContent();
			content= content.replace("\r\n", "<br>");
			dto.setContent(content);
		}
		return list;
	}

	@Override
	public void articleInsert(GuestbookDTO dto) {
		dto.setPost_date(new Date());
		mongoTemplate.insert(dto, COLLECTION_NAME);
	}

	@Override
	public void articleUpdate(GuestbookDTO dto) {
// update guestbook set name=?, email=?, content=?
// where _id=?		
		//new Criteria("필드명").is(값)
		System.out.println(dto);
		Query query=
				new Query(new Criteria("_id").is(dto.get_id()));
		// 수정할 내용들을 매핑
		Update update=new Update();
		update.set("name", dto.getName()); 
		update.set("email", dto.getEmail());
		update.set("content", dto.getContent());
		//1개의 레코드만 수정
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
	}

	@Override
	public void articleDelete(String _id) {
		Query query=new Query(new Criteria("_id").is(_id));
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

	@Override
	public GuestbookDTO gbDetail(String _id) {
		// findById() 1개의 Document 리턴
		// find() Document 리스트 리턴
		// findById(_id, 자료형클래스, 컬렉션이름)
		return mongoTemplate.findById(_id, GuestbookDTO.class
				, COLLECTION_NAME);
	}

}







