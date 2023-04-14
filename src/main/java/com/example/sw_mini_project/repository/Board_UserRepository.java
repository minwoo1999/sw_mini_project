package com.example.sw_mini_project.repository;

import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.Entity.Board_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;

public interface Board_UserRepository extends JpaRepository<Board_User,Long> {

    Board_User findByNameAndBoard_Id(String name,long board_id);
    List<Board_User> findAllByName(String name);
}
