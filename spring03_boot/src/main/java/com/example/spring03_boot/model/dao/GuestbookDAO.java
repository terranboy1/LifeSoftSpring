package com.example.spring03_boot.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.spring03_boot.model.dto.GuestbookDTO;

// mybatis interface mapper (SQL 명령어가 포함된 코드)

public interface GuestbookDAO {
	@Select("select * from guestbook order by idx desc")
	public List<GuestbookDTO> list();
	
	@Insert("insert into guestbook "
+ "(idx,name,email,passwd,content)" 
+" values "
+"(guestbook_seq.nextval, #{name}, #{email}"
+ ", #{passwd},#{content})")
	public void insert(GuestbookDTO dto);
	
	@Select("select * from guestbook where idx=#{idx}")
	public GuestbookDTO view(int idx);
	
	@Update("update guestbook set "
			+ " name=#{name}, email=#{email}, content=#{content}"
			+ " where idx=#{idx}")
	public void update(GuestbookDTO dto);

	@Delete("delete from guestbook where idx=#{idx}")
	public void delete(int idx);
	
}





















