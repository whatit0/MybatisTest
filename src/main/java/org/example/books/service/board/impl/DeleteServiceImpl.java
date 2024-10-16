package org.example.books.service.board.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.books.mapper.board.BoardMapper;
import org.example.books.service.board.DeleteService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteServiceImpl implements DeleteService {
    private final BoardMapper boardMapper;

    @Override
    public void boardDelete(Long boardNo){
        boardMapper.deleteBoard(boardNo);
    }
}
