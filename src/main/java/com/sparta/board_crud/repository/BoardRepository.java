package com.sparta.board_crud.repository;

import com.sparta.board_crud.entity.Board;
import com.sparta.board_crud.dto.BoardListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* @Repository 어노테이션 붙이기
* class를 interface 키워드로 바꾸기
* JpaRepository 상속받고, 사용한 entity는 Board로, 타입은 Long으로
* BoardListResponseDto가 쓸 시간 내림차순 정렬 기능 추가*/

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}
