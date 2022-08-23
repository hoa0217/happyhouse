package com.web.happyhouse.bookmark.service.implementation;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.entity.Bookmark;
import com.web.happyhouse.bookmark.repository.BookmarkRepository;
import com.web.happyhouse.bookmark.service.BookmarkService;
import com.web.happyhouse.user.dto.UserDto;
import com.web.happyhouse.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public List<BookmarkDto> getBookmarkList(Long userId) {
        User user = new User();
        user.setUserId(userId);
        return bookmarkRepository.findBookmarkBy(user)
                .stream()
                .map(entity -> Bookmark.toDto(entity))
                .collect(Collectors.toList());

    }
}
