package com.example.sw_mini_project.controller.dto;

import com.example.sw_mini_project.Entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class BoardReqDto {


    private String category;


    private long registrant_count;

    private String reveration_date;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String writer;


    public Board toEntity(){
        return Board.builder()
                .category(category) // 이름도 validation checking
                .registrant_count(registrant_count) //패스워드를 기재하지않았다면? 문제!! Validation checking
                .revervation_Date(reveration_date)
                .title(title)
                .writer(writer)
                .current_count(1) //처음 default값 1 현재인원
                .build();
    }

}
