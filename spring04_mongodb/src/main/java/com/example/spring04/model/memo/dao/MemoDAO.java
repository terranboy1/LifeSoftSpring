package com.example.spring04.model.memo.dao;

import java.util.List;

import com.example.spring04.model.memo.dto.MemoDTO;

public interface MemoDAO {
	List<MemoDTO> getMemoList();
	void memoInsert(MemoDTO dto);
	MemoDTO memoDetail(String _id);
	void memoUpdate(MemoDTO dto);
	void memoDelete(String _id);
}
