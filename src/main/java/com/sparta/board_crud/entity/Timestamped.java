package com.sparta.board_crud.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;


import java.time.LocalDateTime;

/*
* 생성, 변경 시간을 붙여주는 클래스
* 메인 메소드 있는 application 클래스에
* @EnableJpaAuditing 붙여줘야함
* */


@Getter
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트
public class Timestamped {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
