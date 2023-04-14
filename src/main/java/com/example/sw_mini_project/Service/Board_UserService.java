package com.example.sw_mini_project.Service;

import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.Entity.Board_User;
import com.example.sw_mini_project.exception.CustomApiException;
import com.example.sw_mini_project.exception.CustomVaildationApiException;
import com.example.sw_mini_project.repository.BoardRepository;
import com.example.sw_mini_project.repository.Board_UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.SecondaryTableSecondPass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.validation.constraints.Null;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Board_UserService {

    private final Board_UserRepository board_userRepository;
    private final BoardRepository boardRepository;

    EntityManager em;


    //board_id 와 name값을 보내준다.
    @Transactional
    public long board_register(String name, long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new CustomVaildationApiException("찾을 수 없는 Id입니다");
        });

        Board_User board_user = board_userRepository.findByNameAndBoard_Id(name, id);

        if(board_user!=null){
            throw new CustomApiException("이미 등록된 이름이 있습니다");
        }else{



            Board_User b=new Board_User();
            b.setName(name);
            b.setBoard(board);
            Board_User save = board_userRepository.save(b);

            // 등록이 정상적으로 되었다면 count 처리+=1
            long new_cureent_count = board.getCurrent_count() + 1;
            Board newBoard=new Board(
                    board.getId(),
                    board.getTitle(),
                    board.getRevervation_Date(),
                    board.getCategory(),
                    board.getWriter(),
                    board.getRegistrant_count(),
                    new_cureent_count,
                    board.getCreateDate()
            );
            boardRepository.save(newBoard);

            return save.getId();
        }

    }
}
