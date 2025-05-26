package com.sparta.board_crud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/*
* board에 데이터를 넣을 때의 입력 요청 값을 받음
* annotation 붙이기
* 필드 정보 넣기
*/


@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private String title;

    private String content;

    private String password;
}
