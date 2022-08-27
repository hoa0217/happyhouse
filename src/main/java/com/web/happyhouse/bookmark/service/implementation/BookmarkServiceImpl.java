package com.web.happyhouse.bookmark.service.implementation;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.entity.Bookmark;
import com.web.happyhouse.bookmark.repository.BookmarkRepository;
import com.web.happyhouse.bookmark.service.BookmarkService;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.repository.HouseOnSaleRepository;
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

    private final HouseOnSaleRepository houseOnSaleRepository;


    @Override
    public List<BookmarkDto> getBookmarkList(Long userId) {
        User user = userRepository.findById(userId).get();

        return bookmarkRepository.findAllByUser(user)
                .stream()
                .map(entity -> Bookmark.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void saveBookmark(Long userId, Long houseOnSaleId){
        BookmarkDto bookmarkDto = new BookmarkDto();

        User user = userRepository.getById(userId);
        HouseOnSale houseOnSale = houseOnSaleRepository.getById(houseOnSaleId);

        bookmarkRepository.save(Bookmark.toEntity(bookmarkDto, user, houseOnSale));
    }
}
