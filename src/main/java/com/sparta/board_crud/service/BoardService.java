package com.sparta.board_crud.service;

/*
* board 관련 비즈니스 로직 처리 코드들이 모이는 곳
* annotation 붙이기
* BoardRepository 가져오기
* 기능 메소드 만들기
*/

/* 글 생성
* requestDto를 매개변수로 받기
* 받은 매개변수를 이용해 새 Board 객체를 생성
* repository에 생성한 객체 저장함
* 만든 board객체를 이용해서, responseDto객체도 새로 생성해서 리턴해줌
* */

import com.sparta.board_crud.dto.BoardRequestDto;
import com.sparta.board_crud.dto.BoardResponseDto;
import com.sparta.board_crud.entity.Board;
import com.sparta.board_crud.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 글 생성
    /* requestDto를 매개변수로 받기
    * 받은 매개변수를 이용해 새 Board 객체를 생성
    * repository에 생성한 객체를 저장
    * 만든 board객체를 이용해서, responseDto객체도 새로 생성해서 리턴해줌
    * */
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    // 모든 글 가져오기
    /* requestDto의 list로 리턴타입 지정
        repository에서 findAll로 찾은 것을 리스트에 넣기
        값을 담을 새 배열 만들기 (responseDto이용)
        foreach문으로 board의 값 하나씩 ResponsDto를 이용해 새 객체 만들기
        try catch 문으로 예외처리
    * */
    public List<BoardResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();
            List<BoardResponseDto> responseDtoList =  new ArrayList<>();

            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardResponseDto(board)
                );
            }
            return responseDtoList;
        } catch ( Exception e ) {
//            throw new DBEmptyDataException("a");
        }
        return null;
    }

    // 글 하나 가져오기
    /*
    * reseponseDto로 리턴타입 설정
    * 매개변수로 id값 받기
    * repository에서 id를 기준으로 찾고, elseThrow로 예외처리
    * 찾은 값을 이용해 새로운 reseponseDto 객체로 리턴
    * */
    public BoardResponseDto findOneBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return new BoardResponseDto(board);
    }

    // 글 수정
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    // 글 삭제하기
    @Transactional
    public Long delete(Long id) {
        boardRepository.deleteById(id);
        return id;
    }

//    // 비밀번호 확인
//    @Transactional
//    public boolean checkPassword(Long id, String inputPassword) {
//
//
//        return
//    }

}
