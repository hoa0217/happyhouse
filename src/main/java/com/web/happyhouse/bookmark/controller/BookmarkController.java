package com.web.happyhouse.bookmark.controller;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.service.BookmarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"북마크 컨트롤러"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @ApiOperation(value = "저장된 북마크 리스트 가져오기", notes="현재 유저의 북마크 리스트가져오기")
    @ApiImplicitParam(name="userId", value = "현재 유저의 id")
    @GetMapping("/{userId}")
    public List<BookmarkDto> getBookmarkList(@PathVariable("userId") Long userId){
        return bookmarkService.getBookmarkList(userId);
    }

    @ApiOperation(value = "북마크 저장", notes="북마크 저장하기")

    @PostMapping ("/{userId}/{houseOnSale}")
    public void saveBookmark(@PathVariable("userId") Long userId, @PathVariable("houseOnSaleId") Long houseOnSaleId){

        bookmarkService.saveBookmark(userId, houseOnSaleId);
    }





}
