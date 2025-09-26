package com.board.controller;

import java.io.IOException;
import java.util.List;

import com.board.model.dto.Board;
import com.board.model.service.BoardService;
import com.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	private BoardService service = BoardServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		switch(act) {
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		}
		
		//업데이트 / 삭제 추가하기
		
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("board", service.getBoard(id));
		request.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 조회 -> 서비스 호출 -> 레포지토리 호출 -> 메모리에서 꺼내와서  -> 서비스 -> 컨트롤러
		List<Board> list = service.getList();
		request.setAttribute("list", list); 
		request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
		
		
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//게시글 객체를 생성
		Board board = new Board(title, writer, content);
		
		//등록하자! -> 서비스 호출 -> 레포지토리 호출 -> 메모리저장 -> 레포 -> 서비스 -> 컨트롤러
		service.writeBoard(board);
		
		//등록 확인 or 메인으로 튕기던지
		//1. 메인 튕기기 -> index.jsp 리다이렉트
		
		//2. 조회 -> 리다이렉트
		//2-1. 전체 조회
		response.sendRedirect("board?act=list");
		//2-2. 상세 조회
//		response.sendRedirect("board?act=detail?id=게시글id");
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작성페이지 주세요 -> 포워딩
		request.getRequestDispatcher("/WEB-INF/board/writeform.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
