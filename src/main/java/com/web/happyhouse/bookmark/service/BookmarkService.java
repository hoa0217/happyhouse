package com.web.happyhouse.bookmark.service;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.dto.BookmarkVillaDto;

import java.util.List;


public interface BookmarkService {

    /**
     * user가 가진 북마크리스트
     * @param userId
     * @return
     */
    List<BookmarkDto> getBookmarkList(Long userId);
    List<BookmarkVillaDto> getBookmarkVillaList(Long userId);

    void saveBookmark(Long userId, Long houseOnSaleId);
    void saveBookmarkVilla(Long userId, Long houseOnSaleVillaId);
}
