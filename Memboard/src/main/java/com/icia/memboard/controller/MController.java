package com.icia.memboard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memboard.dto.MDTO;
import com.icia.memboard.service.MService;




@Controller
public class MController {
	
	// ModelAndView를 사용하기 위해 mav 객체 생성
	private ModelAndView mav = new ModelAndView();
			
	// Controller와 Service를 연결
	@Autowired
	private MService msvc;
	
	// 로그인을 사용하기 위한 session 연결
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// joinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "M_Join";	// /WEB-INF/views/joinForm.jsp
	}
	
		@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
		public ModelAndView mJoin(@ModelAttribute MDTO member) throws IllegalStateException, IOException {
			System.out.println("[1]가입 controller : " + member);
			
			mav = msvc.mJoin(member);
			
			System.out.println("[5]가입 controller : " + mav + "\n");
			
			return mav;
		}
		
		// loginForm : 로그인 페이지로 이동
		@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
		public String loginForm() {
			return "M_Login";
		}
		
		// mList : 회원목록 메소드
		@RequestMapping(value = "/memberList", method = RequestMethod.GET)
		public ModelAndView mList() {
			System.out.println("[1]목록 controller");
			
			mav = msvc.mList();
			
			System.out.println("[5]목록 controller : " + mav + "\n");
			
			return mav;
		}
		
		// memberView : 회원정보 상세보기 메소드
		@RequestMapping(value = "/memberView", method = RequestMethod.GET)
		public ModelAndView mView(@RequestParam("fId") String fId) {
			
			System.out.println("[1]controller : " + fId);
					
			mav = msvc.mView(fId);
				
			return mav;
		}
		
		// memberDelete : 회원정보 삭제 메소드
		@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
		public ModelAndView mDelete(@RequestParam("fId") String fId) {
			System.out.println("[1]삭제 controller : " + fId);
			
			mav = msvc.mDelete(fId);
			
			System.out.println("[5]삭제 controller : " + mav + "\n");
			
			return mav;
		}
		
		// memberModiForm : 회원정보 수정 페이지로 이동
		@RequestMapping(value = "/memberModiForm", method = RequestMethod.GET)
		public ModelAndView mModiForm(@RequestParam("fId") String fId) {
			System.out.println("[1]수정p controller : " + fId);
			
			mav = msvc.mModiForm(fId);
			
			System.out.println("[5]수정p controller : " + mav + "\n");
		
			return mav;
		}
		
		// memberModify : 회원정보 수정 메소드
		@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
		public ModelAndView mModify(@ModelAttribute MDTO member) throws UnsupportedEncodingException {
			System.out.println("[1]수정 controller : " + member);
			
			mav = msvc.mModi(member);
			
			System.out.println("[5]수정 controller : " + mav + "\n");
			
			return mav;
		}
		
		// memberLogin : 로그인하기
		@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
		public ModelAndView mLogin(@ModelAttribute MDTO member) {
			System.out.println("[1]로그인 controller : " + member);
			mav = msvc.mLogin(member);
			System.out.println("[5]로그인 controller : " + mav + "\n");
			return mav;
		}
		
		// logout : 로그아웃
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String mLogout() {
			session.invalidate();
			return "index";
		}
}
