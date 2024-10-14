package org.example.books.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardDTO {

    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
    private int boardCnt;
    private Long userNo;
    private String userName;

}
