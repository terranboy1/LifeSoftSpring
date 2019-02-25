package com.example.spring03_boot.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring03_boot.model.dto.GuestbookDTO;
import com.example.spring03_boot.service.GuestbookService;

@Controller // Controller bean으로 등록
public class GuestbookController {

	@Inject // 서비스 빈 inject
	GuestbookService guestbookService; 
	
	@RequestMapping("write.do")
	public String write() {
		return "write"; //write.html로 이동
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute GuestbookDTO dto) {
		guestbookService.insert(dto);
		return "redirect:/list.do";
	}
	
	@RequestMapping("update.do")
	public String update(GuestbookDTO dto) {
		guestbookService.update(dto); //레코드 수정
		return "redirect:/list.do"; //목록으로 이동
	}
	
	@RequestMapping("delete.do")
	public String delete(int idx) {
		guestbookService.delete(idx);
		return "redirect:/list.do";
	}
	
	@RequestMapping("view.do")
	public ModelAndView view(int idx, ModelAndView mav) {
		mav.setViewName("detail"); //이동할 뷰의 이름
		//뷰에 전달할 데이터
		mav.addObject("dto", guestbookService.view(idx));
		return mav;//detail.html로 이동
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("list"); //뷰의 이름
		List<GuestbookDTO> list=guestbookService.list();
		mav.addObject("list", list); //뷰에 전달할 데이터 
		return mav; //뷰로 이동
	}
	
}




