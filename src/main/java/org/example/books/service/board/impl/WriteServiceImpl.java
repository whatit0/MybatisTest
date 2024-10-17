package org.example.books.service.board.impl;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.WriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService {

    private final BoardMapper boardMapper;

    @Override
    @Transactional
    public void writeBoard(BoardDTO boardDTO) {
        boardMapper.writeBoard(boardDTO);
    }
}
