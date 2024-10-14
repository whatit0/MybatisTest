package org.example.books.mapper.board;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.books.dto.board.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 목록 불러오기
    @Select("SELECT b.board_no AS boardNo, b.board_title AS boardTitle, u.user_name AS userName, DATE_FORMAT(b.board_date, '%Y-%m-%d') AS boardDate, b.board_cnt AS boardCnt " +
            "FROM board b JOIN users u ON b.user_no = u.user_no " +
            "ORDER BY b.board_no DESC")
    List<BoardDTO> getBoardList();

    // 게시글 상세히 보기
    @Select("SELECT b.board_no AS boardNo, b.board_title AS boardTitle, b.board_content AS boardContent, u.user_name AS userName, DATE_FORMAT(b.board_date, '%Y-%m-%d') AS boardDate, b.board_cnt AS boardCnt " +
            "FROM board b JOIN users u ON b.user_no = u.user_no " +
            "WHERE board_no = #{boardNo}")
    BoardDTO boardDetail(Long boardNo);

    // 게시글 작성
    @Insert("INSERT INTO board (board_title, board_content, user_no, board_date) " +
            "VALUES (#{boardTitle}, #{boardContent}, #{userNo}, NOW())")
    void writeBoard(BoardDTO boardDTO);

    // 게시글 삭제
    @Delete("DELETE FROM board WHERE board_no = #{boardNo}")
    void deleteBoard(Long boardNo);
}
