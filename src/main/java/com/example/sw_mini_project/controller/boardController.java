package com.example.sw_mini_project.controller;


import com.example.sw_mini_project.Entity.Board;
import com.example.sw_mini_project.Service.BoardService;
import com.example.sw_mini_project.controller.dto.BoardReqDto;
import com.example.sw_mini_project.controller.dto.BoardResDto;
import com.example.sw_mini_project.controller.dto.CMResDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags={"게시글 API"})
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class boardController {

    private final BoardService boardsService;

    @ApiOperation(value="게시글 쓰기",notes="사용자이름을 받아 로그인 후 writer에 사용자이름을 쓰고 글을 작성한다.")
    //로그인 api 경로
    @PostMapping("/write")
    public ResponseEntity<?> board_write(@Valid @RequestBody BoardReqDto boardReqDto) {

        long board_num = boardsService.boardwrite(boardReqDto);
        return new ResponseEntity<>(new CMResDto<>(1,"게시글 쓰기 성공!",board_num), HttpStatus.OK);
    }

    @ApiOperation(value="게시글 리스트 조회",notes="작성한 날짜를 기준으로 페이징처리를 실시하였습니다(10페이지씩)")
    @GetMapping("/list")
    public ResponseEntity<?> board_list(@PageableDefault(size = 10, sort = "createDate",  direction = Sort.Direction.DESC) Pageable pageable){
        List<BoardResDto> getboardlist = boardsService.getboardlist(pageable);
        return new ResponseEntity<>(new CMResDto<>(1,"게시글 쓰기 성공!",getboardlist), HttpStatus.OK);
    }
    @GetMapping("/register/{id}")
    public ResponseEntity<?> board_register(@PathVariable("id") long id){
        long getBoardId = boardsService.board_register(id);
        return new ResponseEntity<>(new CMResDto<>(1,"등록하기 성공!",getBoardId), HttpStatus.OK);
    }

}
