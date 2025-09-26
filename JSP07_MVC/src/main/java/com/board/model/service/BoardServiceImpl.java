package com.board.model.service;

import java.util.List;

import com.board.model.dto.Board;
import com.board.model.repository.BoardRepository;
import com.board.model.repository.BoardRepositoryImpl;

//싱글턴으로 만들어야 한다.
public class BoardServiceImpl implements BoardService {

	private static BoardService service = new BoardServiceImpl();
	private BoardRepository repo = BoardRepositoryImpl.getInstance();
	

	private BoardServiceImpl() {
	}
	
	public static BoardService getInstance() {
		return service;
	}
	
	

	@Override
	public List<Board> getList() {
		return repo.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		//상세로 들어왔다!
		repo.updateViewCnt(id);
		return repo.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		//게시글을 등록 -> Repository 호출
		repo.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub

	}

}
