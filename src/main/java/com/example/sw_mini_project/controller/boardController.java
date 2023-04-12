package com.example.sw_mini_project.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags={"게시글 API"})
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class boardController {

    @ApiOperation(value="게시글 쓰기",notes="게시글쓰기")
    //로그인 api 경로
    @GetMapping("/write")
    public String board_write() {

        return "게시글 쓰기 성공!";
    }

}
