package com.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.model.dto.Board;

//싱글턴으로 
public class BoardRepositoryImpl implements BoardRepository {

	// DB와 소통! -> 메모리에 저장을 하겠다.
	// 게시글 관리 -> Map / List
	private List<Board> list = new ArrayList<>();
	private Map<Integer, Board> map = new HashMap<>();

	private static BoardRepository repo = new BoardRepositoryImpl();

	private BoardRepositoryImpl() {
		Board tmp = new Board("아직은 괜찮아1", "양강사", "사실 안괜찮아~");
		map.put(1, tmp);
		list.add(tmp);

	}

	public static BoardRepository getInstance() {
		return repo;
	}

	@Override
	public List<Board> selectAll() {
//		return list;
		
		List<Board> tmp = new ArrayList<>();
		for(int key : map.keySet()) {
			tmp.add(map.get(key));
		}
		return tmp;
		
//		return (List<Board>)map.values();
	}

	@Override
	public Board selectOne(int id) {
		//list
//		for(Board board : list) {
//			if(board.getId() == id)
//				return board;
//		}
//		return null;
		
		return map.get(id);
	}

	@Override
	public void insertBoard(Board board) {
		list.add(board); // ez
		map.put(board.getId(), board); // ez
	}

	@Override
	public void updateBoard(Board board) {

	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateViewCnt(int id) {
		Board b = map.get(id);
		b.setViewCnt(b.getViewCnt()+1);
	}

}
