package com.example.sw_mini_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Board_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) // 다(Many가있는곳이 외래키고) 이것이 연관관계의 주인이된다.
    @JoinColumn(name="board_id")
    private Board board;




}
