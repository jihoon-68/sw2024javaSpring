package com.constudy.myapp.module;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class MemoDAO {

	private List<Memo> memos = new ArrayList<Memo>();
	
	private int nextId;
	
	public MemoDAO() {
		memos = new ArrayList<Memo>();
		
		nextId =0;
		
		for(int i=0; i< 5; i++) {
			addMemo(new Memo("메모"+i,"메모"+i));
		}
	}
	
	public List<Memo> getAllMemos(){
		System.out.println("getAllMemmos()");
		return memos;
	}
	
	public Memo getOneMemo (int id) {
		for(Memo memo: memos) {
			if(memo.getId() == id) {
				return memo;
			}
		}
		return null;
	}
	
	public void addMemo(Memo memo) {
		memo.setId(nextId++);
		memos.add(memo);
	}
	
	public void updateMemo(int id, Memo updateMemo) {
		System.out.println(updateMemo);
		for(int i=0; i<memos.size(); i++) {
			if(memos.get(i).getId() == id) {
				memos.get(i).setTitle(updateMemo.getTitle());
				memos.get(i).setDetail(updateMemo.getDetail());
				break;
			}
		}
		
	}
	
	public void deleteMemo(int id) {
		memos.removeIf(memo -> memo.getId() == id);
	}
	
}
