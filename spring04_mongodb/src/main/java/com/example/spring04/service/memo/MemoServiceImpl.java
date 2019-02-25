package com.example.spring04.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring04.model.memo.dao.MemoDAO;
import com.example.spring04.model.memo.dto.MemoDTO;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoDAO memoDao;
//메모 목록 리턴	
	@Override
	public List<MemoDTO> getMemoList() {
		return memoDao.getMemoList();
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		memoDao.memoInsert(dto);
	}

	@Override
	public MemoDTO memoDetail(String _id) {
		return memoDao.memoDetail(_id); 
	}

	@Override
	public void memoUpdate(MemoDTO dto) {
		memoDao.memoUpdate(dto); 
	}

	@Override
	public void memoDelete(String _id) {
		memoDao.memoDelete(_id); 
	}

}
