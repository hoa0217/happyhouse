package com.web.happyhouse.bookmark.controller;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.dto.BookmarkVillaDto;
import com.web.happyhouse.bookmark.service.BookmarkService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"관심매물 관리 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "저장된 북마크 리스트 가져오기", notes="현재 유저의 북마크 리스트가져오기")
    @ApiImplicitParam(name="userId", value = "현재 유저의 id")
    @GetMapping("/house/{userId}")
    public ResponseDto<List<BookmarkDto>> getBookmarkList(@PathVariable("userId") Long userId){
        return ResponseDto.res(ResponseCode.OK, bookmarkService.getBookmarkList(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "북마크 저장", notes="북마크 저장하기")
    @PostMapping ("/house/{userId}/{houseOnSaleId}")
    public ResponseDto saveBookmark(@PathVariable("userId") Long userId, @PathVariable("houseOnSaleId") Long houseOnSaleId){
        bookmarkService.saveBookmark(userId, houseOnSaleId);
        return ResponseDto.res(ResponseCode.CREATED);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "저장된 빌라 북마크 리스트 가져오기", notes="현재 유저의 빌라 북마크 리스트가져오기")
    @ApiImplicitParam(name="userId", value = "현재 유저의 id")
    @GetMapping("/villa/{userId}")
    public ResponseDto<List<BookmarkVillaDto>> getBookmarkVillaList(@PathVariable("userId") Long userId){
        return ResponseDto.res(ResponseCode.OK, bookmarkService.getBookmarkVillaList(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "북마크 저장", notes="북마크 저장하기")
    @PostMapping ("/villa/{userId}/{houseOnSaleVillaId}")
    public ResponseDto saveBookmarkVilla(@PathVariable("userId") Long userId, @PathVariable("houseOnSaleVillaId") Long houseOnSaleVillaId){
        bookmarkService.saveBookmarkVilla(userId, houseOnSaleVillaId);
        return ResponseDto.res(ResponseCode.CREATED);
    }

}
