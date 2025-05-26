package com.sparta.board_crud.dto;

import com.sparta.board_crud.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/* Board에서 값을 가져올 때 (응답) Board(직접적인 entity)대신 앞에 써줌
   password같은 정보는 노출시키지 않아도 되기 때문에 필드로 넣지 않음


   Board의 필드 정보 가져오기
   Board를 매개변수로 받아 생성자 만들기
*/

@NoArgsConstructor
@Getter
public class BoardResponseDto {

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    // board의 정보를 받아 boardResponseDto 생성
    public BoardResponseDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = board.getModifiedAt();
        this.modifiedAt = board.getCreatedAt();
    }
}

