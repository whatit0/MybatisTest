package org.example.books.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.service.board.BoardService;
import org.example.books.service.board.UpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardUpdateController {
    private final BoardService boardService;
    private final UpdateService updateService;

    @GetMapping("/update/{boardNo}")
    public String updateForm(@PathVariable("boardNo") Long boardNo, Model model) {
        BoardDTO boardDTO = boardService.boardDetailNo(boardNo);
        model.addAttribute("board", boardDTO);
        return "/board/boardUpdate";
    }

    @PostMapping("/update")
    public ResponseEntity<BoardDTO> updateData(@RequestBody BoardDTO boardDTO) {
        BoardDTO dto = updateService.updateBoard(boardDTO);
        return ResponseEntity.ok(dto);
    }
}
