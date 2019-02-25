package com.example.spring04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.memo.dto.MemoDTO;
import com.example.spring04.service.memo.MemoService;

@Controller
public class MemoController {

	@Autowired // @Inject
	MemoService memoService;
	
	@RequestMapping("/memo.do")
	public String memo() {
		return "memo/memo";
	}
	@RequestMapping("/memo_list.do")
	public ModelAndView memo_list() {
		Map<String,Object> map=new HashMap<>();
		List<MemoDTO> list=memoService.getMemoList();
		map.put("items", list);
		return new ModelAndView("memo/memo_list", "map", map);
	}
	
	@RequestMapping("/memo_insert.do")
	public String memo_insert(@ModelAttribute MemoDTO dto) {
		memoService.memoInsert(dto);
		return "redirect:/memo.do";
	}
	
	@RequestMapping("/memo_view.do")
	public ModelAndView memo_view(String _id) {
		MemoDTO dto=memoService.memoDetail(_id);
		return new ModelAndView("memo/memo_view", "dto", dto);
	}
	
	@RequestMapping("/memo_update.do")
	public String memo_update(@ModelAttribute MemoDTO dto) {
		memoService.memoUpdate(dto);
		return "redirect:/memo.do";
	}
	
	@RequestMapping("/memo_delete.do")
	public String memo_delete(String _id) {
		memoService.memoDelete(_id);
		return "redirect:/memo.do";
	}
}









