package com.example.spring05.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring05.model.dao.SurveyDAO;
import com.example.spring05.model.dto.AnswerDTO;
import com.example.spring05.model.dto.SurveyDTO;

@Controller //controller bean
public class SurveyController {

	//@Inject //의존관계 주입
	@Autowired
	SurveyDAO surveyDao;
	
	@RequestMapping("/") // http://localhost/spring05
	public ModelAndView show_survey() {
		SurveyDTO dto=surveyDao.showSurvey(1); //1번 설문
		// main.jsp로 포워딩, 전달할 변수명 dto
		return new ModelAndView("main","dto",dto);
	}
	
	@RequestMapping("/save_survey.do")
	public String save_survey(@ModelAttribute AnswerDTO dto	) {
		surveyDao.save(dto); //테이블에 저장
		return "success"; //success.jsp로 포워딩
	}
	
	@RequestMapping("/show_result.do")
	public ModelAndView show_result() {
		Map<String,Object> map=new HashMap<>();
		//설문문항 내용
		SurveyDTO dto=surveyDao.showSurvey(1);
		//설문응답 리스트
		List<AnswerDTO> items=surveyDao.showResult(1);
		//map에 자료 저장
		map.put("dto", dto);
		map.put("list", items);
		//result.jsp로 포워딩, 변수명 : map
		return new ModelAndView("result", "map", map);
	}
}












