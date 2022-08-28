package com.web.happyhouse.bookmark.service.implementation;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.dto.BookmarkVillaDto;
import com.web.happyhouse.bookmark.entity.Bookmark;
import com.web.happyhouse.bookmark.entity.BookmarkVilla;
import com.web.happyhouse.bookmark.repository.BookmarkRepository;
import com.web.happyhouse.bookmark.repository.BookmarkVillaRepository;
import com.web.happyhouse.bookmark.service.BookmarkService;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOnSaleVilla;
import com.web.happyhouse.house.repository.HouseOnSaleRepository;
import com.web.happyhouse.house.repository.HouseOnSaleVillaRepository;
import com.web.happyhouse.user.entity.User;
import com.web.happyhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final BookmarkVillaRepository bookmarkVillaRepository;
    private final HouseOnSaleVillaRepository houseOnSaleVillaRepository;
    private final HouseOnSaleRepository houseOnSaleRepository;


    @Override
    public List<BookmarkDto> getBookmarkList(Long userId){
        User user = userRepository.findById(userId).get();

        return bookmarkRepository.findAllByUser(user)
                .stream()
                .map(entity -> Bookmark.toDto(entity))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkVillaDto> getBookmarkVillaList(Long userId){
        User user = userRepository.findById(userId).get();

        return bookmarkVillaRepository.findAllByUser(user)
                .stream()
                .map(entity -> BookmarkVilla.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void saveBookmark(Long userId, Long houseOnSaleId){

        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 ID(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        HouseOnSale houseOnSale = houseOnSaleRepository.findById(houseOnSaleId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 ID(" + houseOnSaleId + ")의 매물 찾을 수 없습니다.");
        });

        bookmarkRepository.save(Bookmark.createBookmark(user, houseOnSale));
    }

    @Override
    public void saveBookmarkVilla(Long userId, Long houseOnSaleVillaId){

        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 ID(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        HouseOnSaleVilla houseOnSaleVilla = houseOnSaleVillaRepository.findById(houseOnSaleVillaId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 ID(" + houseOnSaleVillaId + ")의 빌라 매물 찾을 수 없습니다.");
        });

        bookmarkVillaRepository.save(BookmarkVilla.createBookmark(user, houseOnSaleVilla));
    }
}
