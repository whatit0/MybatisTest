package org.example.books.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/home")
    public String mainHome() {
        return "index.html";
    }

//    @GetMapping("/boards")
//    public String boardPage() {
//        return "/board/boardList";
//    }

    @GetMapping("/user/create")
    public String idCreate() {
        return "/user/userCreate";
    }
}
