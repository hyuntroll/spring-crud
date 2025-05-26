package com.sparta.board_crud.entity;

import com.sparta.board_crud.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;



/*
    annotation 붙이기
    필드 정보 만들기
    RquestDto 만들기
    시간 기능을 위해 Timestamped 클래스 상속
*/


@Setter
@Getter // get 함술르 일괄적으로 만들어줌
@NoArgsConstructor // 기본 생성자를 만들어줌
@Entity( name = "users" ) // DB 테이블 역할을 함.

public class Board extends Timestamped {
    // 글 고유 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 글 제목
    @Column(nullable = false)
    private String title;

    // 글 내용
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    // requestDto 정보를 가져와서 entity 만들 때 사용
    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    // 업데이트 메소드
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
