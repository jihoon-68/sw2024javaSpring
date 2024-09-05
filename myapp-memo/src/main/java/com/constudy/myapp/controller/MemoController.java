package com.constudy.myapp.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.constudy.myapp.module.Memo;
import com.constudy.myapp.module.MemoDAO;




@Controller
public class MemoController {
	
	private final MemoDAO memoDAO;
	
	public MemoController(MemoDAO memoDAO) {
		this.memoDAO = memoDAO;
	}
	 
	@GetMapping("/")
	public String listMemos(Model model) {
		model.addAttribute("memos",memoDAO.getAllMemos());
		return "memolist";
	} 
	
	
	@PostMapping("/add")
	public String addMemo(@ModelAttribute Memo memo) {
		System.out.println(memo);
		memoDAO.addMemo(memo);
		return "redirect:/";
	}
	
	@GetMapping("/detail/{id}")
	public String detailMemos(@PathVariable int id, Model model) {
		model.addAttribute("memo",memoDAO.getOneMemo(id));
		return "detail";
	}
	
	@PostMapping("/detail/{id}")
	public String updateMemos(@PathVariable int id, @ModelAttribute Memo memo) {
		System.out.println(memo);
		System.out.println(id);
		memoDAO.updateMemo(id,memo);
		
		return "detail";
	}
	
	@GetMapping("/delete/{id}")
	public String getMethodName(@PathVariable int id) {
		memoDAO.deleteMemo(id);
		return "redirect:/";
	}
	
}
