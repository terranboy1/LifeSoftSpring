package com.example.spring05.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring05.model.dto.AnswerDTO;
import com.example.spring05.model.dto.SurveyDTO;

@Repository //dao bean
public class SurveyDAOImpl implements SurveyDAO {

	@Inject //mybatis 실행을 위한 객체를 주입
	SqlSession sqlSession;
	
	@Override
	public SurveyDTO showSurvey(int survey_idx) {
		//selectOne 레코드 1개, selectList 레코드 리스트
		return sqlSession.selectOne("show_survey", survey_idx); 
	}

	@Override
	public void save(AnswerDTO dto) {
		sqlSession.insert("save_answer", dto);
	}

	@Override
	public List<AnswerDTO> showResult(int survey_idx) {
		return sqlSession.selectList("show_result", survey_idx);
	}

}










