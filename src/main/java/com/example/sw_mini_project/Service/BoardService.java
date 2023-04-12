package com.example.sw_mini_project.Service;

import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.controller.dto.BoardReqDto;
import com.example.sw_mini_project.controller.dto.BoardResDto;
import com.example.sw_mini_project.exception.CustomVaildationApiException;
import com.example.sw_mini_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


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

    @Transactional
    public long board_register(long id) {
        // 등록 시 해당하는 아아디를 찾고 등록인원 +1 시켜주는 로직
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new CustomVaildationApiException("찾을 수 없는 Id입니다");
        });
        //아이디를 찾았으면 current_count에 +1을 해준다.
        if (board.getId() != null) {
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
            Board save = boardRepository.save(newBoard);
            return save.getId();
        }else{
            return 0;
        }



    }
}
