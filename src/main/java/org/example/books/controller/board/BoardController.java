package org.example.books.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.books.dto.board.BoardDTO;
import org.example.books.service.board.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시글 목록 보기
    @GetMapping("/list")
    public String boardsList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                             Model model) {
        List<BoardDTO> boardList = boardService.getBoardList(page, pageSize);
        int totalCount = boardService.totalBoard();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        int pageLimit = 5;
        int startPage = ((page - 1) / pageLimit) * pageLimit + 1;
        int endPage = Math.min(startPage + pageLimit -1, totalPages);

        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "/board/boardList";
    }

    // 게시글 자세히 보기
    @GetMapping("/detail/{boardNo}")
    public String boardDetail(@PathVariable("boardNo") Long boardNo, Model model) {
        boardService.boardCnt(boardNo); // 추후 같은 아이디로 동일 게시물을 볼 경우 증가x 추가
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
