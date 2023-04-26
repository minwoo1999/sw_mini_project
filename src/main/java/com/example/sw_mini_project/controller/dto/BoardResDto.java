package com.example.sw_mini_project.controller.dto;

import com.example.sw_mini_project.Entity.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;



@Data
public class BoardResDto {
    private long id;

    private String category;


    private long registrant_count;

    private String reveration_date;

    private long current_count;

    private String title;

    private String writer;

    public BoardResDto(Board board) {
        this.id=board.getId();
        this.category=board.getCategory();
        this.registrant_count=board.getRegistrant_count();
        this.reveration_date=board.getRevervation_Date();
        this.title=board.getTitle();
        this.writer=board.getWriter();
        this.current_count=board.getCurrent_count();
    }
}
