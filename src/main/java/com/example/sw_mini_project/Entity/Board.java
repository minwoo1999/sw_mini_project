package com.example.sw_mini_project.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert //@DynamicInsert사용 default 값 설정 시 사용
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //제목
    private String title;

    // 날짜 및 시간 (만나는 날)

    private Date revervation_Date;

    //카테고리

    private String category;

    //작성자

    private String writer;

    //접수인원
    private long registrant_count;

    private long current_count;

    //작성날짜
    private LocalDateTime createDate;

    @PrePersist //디비에 insert 되기직전에 실행
    public void createDate(){
        this.createDate= LocalDateTime.now();
    }

    public Board(Long id, String title, Date revervation_Date, String category, String writer, long registrant_count, long current_count, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.revervation_Date = revervation_Date;
        this.category = category;
        this.writer = writer;
        this.registrant_count = registrant_count;
        this.current_count = current_count;
        this.createDate = createDate;
    }
}
