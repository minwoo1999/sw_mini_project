package com.example.sw_mini_project.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert //@DynamicInsert사용 default 값 설정 시 사용
public class Board {


    @Column(name = "board_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //제목
    private String title;

    // 날짜 및 시간 (만나는 날)

    private String revervation_Date;

    //카테고리

    private String category;

    //작성자

    private String writer;

    //접수인원
    private long registrant_count;
    //현재인원
    private long current_count;

    //작성날짜
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    private LocalDateTime createDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @PrePersist //디비에 insert 되기직전에 실행
    public void createDate(){
        this.createDate= LocalDateTime.now();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
    private List<Board_User> board_user=new ArrayList<>();

    @Builder
    public Board(Long id, String title, String revervation_Date, String category, String writer, long registrant_count, long current_count, LocalDateTime createDate) {
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
