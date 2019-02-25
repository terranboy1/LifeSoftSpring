package com.example.spring05.model.dao;

import java.util.List;

import com.example.spring05.model.dto.AnswerDTO;
import com.example.spring05.model.dto.SurveyDTO;

public interface SurveyDAO {
	//설문문항 보기
	public SurveyDTO showSurvey(int survey_idx);
	//설문응답 처리
	public void save(AnswerDTO dto);
	//설문결과 보기
	public List<AnswerDTO> showResult(int survey_idx);
}
