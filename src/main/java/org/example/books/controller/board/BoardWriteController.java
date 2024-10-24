package org.example.books.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.service.board.WriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardWriteController {

    private final WriteService writeService;

    @PostMapping("/write")
    public ResponseEntity<String> writeBoard(@RequestBody BoardDTO boardDTO) {
        // 일단 임시로 user_no을 1로 지정
        boardDTO.setUserNo(2L);
        writeService.writeBoard(boardDTO);
        return ResponseEntity.ok("성공");
    }
}
