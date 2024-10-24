package org.example.books.service.board.impl;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getBoardList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return boardMapper.pagingBoard(pageSize, offset);
    }

    @Override
    public int totalBoard() {
        return boardMapper.totalBoard();
    }

    @Override
    public BoardDTO boardDetailNo(Long boardNo) {
        return boardMapper.boardDetail(boardNo);
    }

    @Override
    @Transactional  // 트랜잭션을 자동으로 관리, 커밋 & 롤백을 통해 데이터 일관성 유지
    public void boardCnt(Long boardNo) {
        boardMapper.cntBoard(boardNo);
    }
}
