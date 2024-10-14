package org.example.books.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.books.service.board.DeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardDeleteController {

    private final DeleteService deleteService;

    @GetMapping("/delete/{boardNo}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardNo") Long boardNo) {
        deleteService.boardDelete(boardNo);
        return ResponseEntity.ok("삭제 완료");
    }
}
