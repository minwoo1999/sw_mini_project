package com.example.sw_mini_project.Service;

import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.Entity.Board_User;
import com.example.sw_mini_project.controller.dto.BoardReqDto;
import com.example.sw_mini_project.controller.dto.BoardResDto;
import com.example.sw_mini_project.repository.BoardRepository;
import com.example.sw_mini_project.repository.Board_UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final Board_UserRepository board_userRepository;


    @Transactional
    public long boardwrite(BoardReqDto boardReqDto){

    // dto를 toEntity
        Board board = boardReqDto.toEntity();
    // entity 객체 저장
        Board saveboard = boardRepository.save(board);
    // 저장하는거니까 id 만 반환
        return saveboard.getId();

    }
    @Transactional(readOnly = true)
    public List<BoardResDto> getboardlist(Pageable pageable){
        Page<Board> Pagingboard = boardRepository.findAll(pageable);

        List<BoardResDto> pagingboard = Pagingboard.stream().map(board -> new BoardResDto(board))
                .collect(Collectors.toList());

        return pagingboard;
    }

    public List<Board> getMypage(String name,Pageable pageable) {

        List<Board_User> board_user = board_userRepository.findAllByName(name);
        List<Board> list=new ArrayList<>();
        for (Board_User boardUser : board_user) {
            Long board_id = boardUser.getBoard().getId();
            System.out.println(board_id);
             Optional<Board> board = boardRepository.findById(board_id);
             list.add(board.get());
        }
        return list;
    }

}
