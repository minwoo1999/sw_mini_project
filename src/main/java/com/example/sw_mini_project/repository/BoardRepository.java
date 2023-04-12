package com.example.sw_mini_project.repository;

import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.controller.dto.BoardReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;

public interface BoardRepository extends JpaRepository<Board,Long> {

//    @Modifying //INSERT,DELETE,UPDATE 를 네이티브 쿼리로 작성하려면 해당 어노테이션이 필요함
//    @Query(value="update board set current_count=current_count+1 where id= :id)",nativeQuery = true)
//    Integer board_register(long id);
}
