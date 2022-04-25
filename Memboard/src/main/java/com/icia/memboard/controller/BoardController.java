package com.icia.memboard.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memboard.dto.BoardDTO;
import com.icia.memboard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bsvc;
	
	private ModelAndView mav = new ModelAndView();
	
	
	// writeForm : 게시글 작성 페이지로 이동
	@RequestMapping(value="/writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "B_Write";
	}
	
	// boardWrite : 게시글 작성 메소드
	@RequestMapping(value="/boardWrite", method = RequestMethod.POST)
	public ModelAndView bWrite(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1]작성 controller : " + board);
		mav = bsvc.bWrite(board);
		
		System.out.println("[5]작성 controller : " + mav);
		return mav;
	}
	
	// boardList : 게시글 목록 메소드
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView bList() {
		System.out.println("[1]목록 controller");
		
		mav = bsvc.bList();
		
		System.out.println("[5]목록 controller : " + mav + "\n");
		
		return mav;
	}
	
	// boardView : 게시글 상세 보기
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public ModelAndView bView(@RequestParam("bNum") int bNum) {
		System.out.println("[1]상세 controller");
		
		mav = bsvc.bView(bNum);
		
		System.out.println("[5]상세 controller : " + mav + "\n");
		
		return mav;
	}
	
	// modiForm : 게시글 수정 페이지로 이동
	@RequestMapping(value = "/modiForm", method = RequestMethod.GET)
	public ModelAndView modiForm(@RequestParam("bNum") int bNum) {
		System.out.println("[1]수정p controller");
		mav = bsvc.modiForm(bNum);
		
		System.out.println("[5]수정p controller : " + mav + "\n");
		return mav;
	
	}
	
	// boardModify : 게시글 수정 메소드
	@RequestMapping(value="/boardModify", method = RequestMethod.POST)
	public ModelAndView bModify(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[1]수정 controller : " + board);
		mav = bsvc.bModify(board);
		
		System.out.println("[5]수정 controller : " + mav);
		return mav;
	}
	
	// boardDelete : 게시글 삭제 메소드
	
		@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
		public ModelAndView bDelete(@RequestParam("bNum") int bNum) {
			System.out.println("[1]삭제 controller : " + bNum);
			mav = bsvc.bDelete(bNum);
			
			System.out.println("[5]삭제 controller : " + mav + "\n");
			return mav;
	
		}
		
		// pagingList : 페이징 처리 메소드
		@RequestMapping(value = "/pagingList", method = RequestMethod.GET)
		public ModelAndView pList(@RequestParam(value="page",required = false, defaultValue = "1")int page, @RequestParam(value="limit",required = false, defaultValue = "5")int limit) {
			// value : jsp 혹은 다른 메소드에서 넘겨주는 매개변수 이름
			// required : false일때 page값을 받아오지 않아도 상관없다, true일때 무조건 page값을 받아와야 한다.
			// defaultValue="1" : required가 false일때 page값을 1로 설정한다
			
			// 오류방지용
			if(page<=0) {
				page = 1;
			}
			
			mav = bsvc.pList(page, limit);
			
			return mav;
		}

}
