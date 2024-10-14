package org.example.books.service.board.impl;

import lombok.AllArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public BoardDTO boardDetailNo(Long boardNo) {
        return boardMapper.boardDetail(boardNo);
    }
}
