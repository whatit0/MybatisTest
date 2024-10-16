package org.example.books.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.service.board.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시글 목록 보기
    @GetMapping("/list")
    public String boardsList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "/board/boardList";
    }

    // 게시글 자세히 보기
    @GetMapping("/detail/{boardNo}")
    public String boardDetail(@PathVariable("boardNo") Long boardNo, Model model) {
        BoardDTO boardDTO = boardService.boardDetailNo(boardNo);
        model.addAttribute("board", boardDTO);
        return "/board/boardDetail";
    }

    // 게시글 작성
    @GetMapping("/write")
    public String boardWrite() {
        return "board/boardWrite";
    }
}
