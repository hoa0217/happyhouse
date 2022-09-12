package com.web.happyhouse.bookmark.repository;

import com.web.happyhouse.bookmark.entity.Bookmark;
import com.web.happyhouse.bookmark.entity.BookmarkVilla;
import com.web.happyhouse.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkVillaRepository extends JpaRepository<BookmarkVilla, Long> {

    List<BookmarkVilla> findAllByUser(User user);

}
