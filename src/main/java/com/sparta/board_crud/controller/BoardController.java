package com.sparta.board_crud.controller;


import com.sparta.board_crud.dto.BoardRequestDto;
import com.sparta.board_crud.dto.BoardResponseDto;
import com.sparta.board_crud.service.BoardService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
* annotation 붙이기
* boardService 가져오고, 생성자 생성
* 알맞는 Mapping으로 생성
* */
@Tag(name="board", description = "testAPI")
@RestController // JSON으로 데이터를 주고받음을 선언.
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글 등록
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        BoardResponseDto board = boardService.createBoard(requestDto);
        return board;
    }

    // 전체 목록 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> getAllBoards() {
        return boardService.findAllBoard();
    }

    // 글 하나 조회
    @GetMapping("/board/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.findOneBoard(id);
    }

    // 글 수정
    @PutMapping("/boards/{id}")
    public Long updateboard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    // 글 삭제
//    @Hidden
    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.delete(id);
    }

    // 비밀번호 확인
//    @GetMapping("/boards/check/{id}/{inputPassword}")
//    public boolean checkPassword(@PathVariable Long id, @PathVariable String inputPassword) {
//        return boardService.checkPassword(id, inputPassword);
//    }
}
