package com.web.happyhouse.bookmark.controller;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.service.BookmarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"북마크 컨트롤러"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @ApiOperation(value = "동에 있는 원룸 정보 리스트 조회", notes="동에 해당하는 원룸 정보 List (Map)")
    @ApiImplicitParam(name="userId", value = "현재 유저의 id")
    @GetMapping("/{userId}")
    public List<BookmarkDto> getBookmarkList(@PathVariable("userId") Long userId){
        return bookmarkService.getBookmarkList(userId);
    }
}
