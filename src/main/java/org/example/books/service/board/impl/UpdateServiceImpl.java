package org.example.books.service.board.impl;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.UpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateServiceImpl implements UpdateService {
    private final BoardMapper boardMapper;

    @Override
    @Transactional
    public BoardDTO updateBoard(BoardDTO boardDTO) {
        boardMapper.updateBoard(boardDTO.getBoardTitle(), boardDTO.getBoardContent(), boardDTO.getBoardNo());
        return boardMapper.boardDetail(boardDTO.getBoardNo());
    }
}
