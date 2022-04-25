package com.icia.memboard.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memboard.dao.MemboardDAO;
import com.icia.memboard.dto.MDTO;




@Service
public class MService {

	
	// ModelAndView를 사용하기 위해 mav 객체 생성
	private ModelAndView mav = new ModelAndView();
			
	// Controller와 DAO를 연결
	@Autowired
	private MemboardDAO dao;
	
	@Autowired
	private HttpSession session;

	public ModelAndView mJoin(MDTO member) throws IllegalStateException, IOException {
	System.out.println("[2]가입 service : " + member);
	// DB에 잘 저장됐는지 확인하기 위한 , 회원가입이 성공했는지 확인하기 위한 변수 result생성
	
	// 중복된 파일 이름 방지를 위한 UUID
	UUID uuid = UUID.randomUUID();
				
	// 파일 업로드를 위한 파일처리
	MultipartFile fProfile = member.getfProfile();
			
	// 업로드한 파일의 이름
	String fileName = uuid.toString().substring(0,8) + "_" + fProfile.getOriginalFilename();
	// movie1.jpg업로드 할 경우 ce021c81_movie1.jpg로 저장됨
	
	String savePath = "C:/Users/user/SpringWorkSpace/Memboard/src/main/webapp/resources/fileUpload/" + fileName ;
	
	if(!fProfile.isEmpty()) {
		fProfile.transferTo(new File(savePath));
		member.setfProfileName(fileName);
	}
	
	int result = dao.mJoin(member);
	System.out.println("[4]가입 service : " + result);

	if (result > 0) {
			
		mav.setViewName("index");
		} else {
			
		mav.setViewName("M_Join");
		}

		return mav;
	}

	public ModelAndView mList() {
		System.out.println("[2]목록 service");

		// 메소드를 만들면 해줘야 하는 것
		// (1) 메소드 타입의 return값 설정
		List<MDTO> memberList = dao.mList();

		System.out.println("[4]목록 service : " + memberList);

		mav.setViewName("M_List");
		mav.addObject("memberList", memberList);

		// mav.addObject("jsp에서 사용할 이름", jsp에서 사용할 데이터);

		return mav;
	}

	public ModelAndView mView(String fId) {
		System.out.println("[2]service : " + fId);
		
		MDTO member = dao.mView(fId);
		
		System.out.println("[4]service : " + member);
		
		mav.setViewName("M_View");
		mav.addObject("view", member);
		
		// memView.jsp에서 member의 값을 view라는 이름으로 사용하겠다.
		
		return mav;
	}

	public ModelAndView mDelete(String fId) {
		System.out.println("[2]삭제 service : " + fId);

		int result = dao.mDelete(fId);

		System.out.println("[4]삭제 service : " + result);

		if (result > 0) {
			// 삭제성공
			mav.setViewName("redirect:/memberList");
		} else {
			// 삭제실패
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView mModiForm(String fId) {
		System.out.println("[2]수정p service : " + fId);
		// 상세보기 할 아이디의 정보(?)
		// 수정 할 아이디의 정보
		MDTO member = dao.mView(fId);
		System.out.println("[4]수정p service : " + member);
		// DB에서 가져온 member의 정보를 modiForm.jsp에서 "modi"라는 이름으로 사용한다.
		mav.setViewName("M_Modi");
		mav.addObject("modi", member);

		return mav;
	}

	public ModelAndView mModi(MDTO member) throws UnsupportedEncodingException {
		System.out.println("[2]수정 service : " + member);

		// DB에 잘 저장됐는지 확인하기 위한 , 회원수정이 성공했는지 확인하기 위한 변수 result생성
		int result = dao.mModi(member);

		System.out.println("[4]수정 service : " + result);

		if (result > 0) {
			// 회원수정성공 result = 1
			String id = URLEncoder.encode(member.getfId(),"UTF-8");
			mav.setViewName("redirect:/memberView?mId=" + id);
		} else {
			// 회원수정실패 result=0
			mav.setViewName("redirect:/memberList");
		}

		return mav;
	}

	public ModelAndView mLogin(MDTO member) {
		System.out.println("[2]로그인 service : " + member);
		String loginId = dao.mLogin(member);

		System.out.println("[4]로그인 service : " + loginId);
		
		if(loginId != null) {
			session.setAttribute("loginId", loginId);
			mav.setViewName("index");
		} else {
			mav.setViewName("M_Login");
		}
		
		return mav;
	}

	
}
