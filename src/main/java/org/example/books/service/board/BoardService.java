package org.example.books.service.board;

import org.example.books.dto.board.BoardDTO;

import java.util.List;

public interface BoardService {

    // 게시글 목록 보기
    List<BoardDTO> getBoardList();

    // 게시글 자세히 보기
    BoardDTO boardDetailNo(Long boardNo);

    // 조회 수 반영
    void boardCnt(Long boardNo);
}
