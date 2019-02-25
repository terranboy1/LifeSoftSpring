package com.example.spring04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.guestbook.dao.GuestbookDAO;
import com.example.spring04.model.guestbook.dto.GuestbookDTO;

@Controller
public class GuestbookController {

	@Autowired
	GuestbookDAO guestbookDao;
	
	@RequestMapping("/guestbook.do")
	public String guestbook() {
		return "guestbook/guestbook";
	}
	
	@RequestMapping("/gbList.do")
	public ModelAndView gbList() {
		List<GuestbookDTO> items=guestbookDao.getArticleList();
		Map<String,Object> map=new HashMap<>();
		map.put("list", items);
		map.put("count", items.size());
		return new ModelAndView("guestbook/gb_list", "map", map);
	}
	
	@RequestMapping("/gbWrite.do")
	public String gbWrite() {
		return "guestbook/gb_write";
	}
	
	@RequestMapping("/gbInsert.do")
	public String gbInsert(@ModelAttribute GuestbookDTO dto) {
		//mongodb에 Document(레코드) 추가
		guestbookDao.articleInsert(dto);
		//페이지 이동(목록 갱신)
		return "redirect:/guestbook.do";
	}
	
	@RequestMapping("/gbEdit.do")
	public ModelAndView gbEdit(String _id) {
		// _id : mongodb의 Document(레코드)의 식별자
		GuestbookDTO dto=guestbookDao.gbDetail(_id);
		Map<String,Object> map=new HashMap<>();
		map.put("dto", dto);
		return new ModelAndView("guestbook/gb_edit","map",map);
	}
	
	@RequestMapping("/gbUpdate.do")
//	public String gbUpdate(@ModelAttribute GuestbookDTO dto) {
	public String gbUpdate(@RequestParam String _id
			, @RequestParam String name
			, @RequestParam String email
			, @RequestParam String content
			, @RequestParam String passwd) {		
		//System.out.println(dto);
		//Document(레코드) 수정
		GuestbookDTO dto=new GuestbookDTO();
		dto.set_id(_id);
		dto.setName(name);
		dto.setEmail(email);
		dto.setContent(content);
		dto.setPasswd(passwd);
		
		guestbookDao.articleUpdate(dto);
		//목록 페이지로 이동
		return "redirect:/guestbook.do";
	}
	
	@RequestMapping("/gbDelete.do")
	public String gbDelete(String _id) {
		//Document(레코드) 삭제
		guestbookDao.articleDelete(_id);
		//목록 페이지로 이동
		return "redirect:/guestbook.do";
	}
}














