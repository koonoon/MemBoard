package com.icia.memboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memboard.dao.BoardDAO;
import com.icia.memboard.dto.BoardDTO;
import com.icia.memboard.dto.PageDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	private ModelAndView mav = new ModelAndView();
	
	public ModelAndView bWrite(BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[2]작성Service : " + board);
		// 중복된 파일 이름 방지를 위한 UUID
		UUID uuid = UUID.randomUUID();
					
		// 파일 업로드를 위한 파일처리
		MultipartFile bFile = board.getbFile();
				
		// 업로드한 파일의 이름
		String fileName = uuid.toString().substring(0,8) + "_" + bFile.getOriginalFilename();
		// movie1.jpg업로드 할 경우 ce021c81_movie1.jpg로 저장됨
		
		String savePath = "C:/Users/user/SpringWorkSpace/Board21/src/main/webapp/resources/fileUpload/" + fileName ;
		
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
			board.setbFileName(fileName);
		}
		
		int result = dao.bWrite(board);
		
		System.out.println("[4]작성Service : " + result);
		
		if(result>0) {
			// 등록성공
			mav.setViewName("redirect:/boardList");
		} else {
			// 등록실패
			mav.setViewName("index");
		}
		
		return mav;
	}

	public ModelAndView bList() {
		System.out.println("[2]목록 service");

		List<BoardDTO> boardList = dao.bList();

		System.out.println("[4]목록 service : " + boardList);

		mav.setViewName("B_List");
		mav.addObject("boardList", boardList);

		return mav;
	}

	public ModelAndView bView(int bNum) {
		System.out.println("[2]상세 service : " + bNum);
		BoardDTO board = dao.bView(bNum);

		System.out.println("[4]상세 service : " + board);
		
		mav.addObject("view", board);
		mav.setViewName("B_View");
		
		return mav;
	}

	// 게시글 수정페이지로 이동
	public ModelAndView modiForm(int bNum) {
		System.out.println("[2]수정p service : " + bNum);
		BoardDTO board = dao.bView(bNum);

		System.out.println("[4]수정p service : " + board);
		
		mav.addObject("modi", board);
		mav.setViewName("B_Modify");
		
		return mav;
	}

	public ModelAndView bModify(BoardDTO board) throws IllegalStateException, IOException {
		System.out.println("[2]수정Service : " + board);
		
		// 중복된 파일 이름 방지를 위한 UUID
		UUID uuid = UUID.randomUUID();
			
		// 파일 업로드를 위한 파일처리
		MultipartFile bFile = board.getbFile();
		
		// 업로드한 파일의 이름
		String fileName = uuid.toString().substring(0,8) + "_" + bFile.getOriginalFilename();
		// movie1.jpg업로드 할 경우 ce021c81_movie1.jpg로 저장됨
		
		
		// 파일이 저장된 주소
		String savePath = "C:/Users/user/SpringWorkSpace/Board21/src/main/webapp/resources/fileUpload/" + fileName ;
		
		// 파일 업로드 유무 확인
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
			board.setbFileName(fileName);
		}
		
		int result = dao.bModify(board);
		
		System.out.println("[4]수정Service : " + result);
		
		if(result>0) {
			// 수정성공
			mav.setViewName("redirect:/boardView?bNum="+board.getbNum());
		} else {
			// 수정실패
			mav.setViewName("redirect:/boardList");
		}
		
		return mav;
	}

	// 게시글 삭제 메소드
	public ModelAndView bDelete(int bNum) {
		System.out.println("[2]삭제 service : " + bNum);
		int result = dao.bDelete(bNum);

		System.out.println("[4]삭제 service : " + result);
		
		if(result>0) {
			mav.setViewName("redirect:/boardList");
		} else {
			mav.setViewName("redirect:/boardView?bNum="+bNum);
		}
		
		return mav;
	}

	// 한 화면에 보여줄 페이지 번호 갯수
	// private static final int BLOCK = 5;
	
	// 페이징처리 메소드
	public ModelAndView pList(int page, int limit) {
		
		// 한 화면에 보여줄 페이지 번호 갯수
		int block = 5;
		
		
		
		// 전체 게시글 갯수
		int listCount = dao.bCount();
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		// limit 한페이지 보여줄 게시글 갯수 : 5
		// page : 1 / startRow = 1 / endRow = 5
		// page : 2 / startRow = 6 / endRow = 10
		
		int maxPage = (int)(Math.ceil((double)listCount/limit));	// 7
		int startPage = (((int)(Math.ceil((double)page/block)))-1) * block + 1;
		int endPage = startPage + block - 1;
		
		// 오류방지
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이지 객체 생성
		PageDTO paging = new PageDTO(); 
		
		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setLimit(limit);
		
		List<BoardDTO> plist = dao.pList(paging);
		
		mav.addObject("plist", plist);
		mav.addObject("paging", paging);
		
		mav.setViewName("P_List");
		
		return mav;
	}
	
}
