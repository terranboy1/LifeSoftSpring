package com.example.spring04.model.guestbook.dao;

import java.util.List;

import com.example.spring04.model.guestbook.dto.GuestbookDTO;

public interface GuestbookDAO {
	public List<GuestbookDTO> getArticleList(); //방명록 목록
	public void articleInsert(GuestbookDTO dto); //글쓰기
	public void articleUpdate(GuestbookDTO dto); //수정
	public void articleDelete(String _id); //삭제
	public GuestbookDTO gbDetail(String _id); //상세화면
}









