package org.example.books.service.board.impl;

import lombok.AllArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.WriteService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WriteServiceImpl implements WriteService {

    private final BoardMapper boardMapper;

    @Override
    public void writeBoard(BoardDTO boardDTO) {
        boardMapper.writeBoard(boardDTO);
    }
}
