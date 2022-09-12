package com.web.happyhouse.bookmark.entity;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark{

    @Id @GeneratedValue
    @Column(name = "bookmark_id")
    private Long bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_on_sale_id")
    private HouseOnSale houseOnSale;

    @Builder
    public Bookmark(Long bookmarkId, User user, HouseOnSale houseOnSale) {
        this.bookmarkId = bookmarkId;
        this.user = user;
        this.houseOnSale = houseOnSale;
    }

    public static Bookmark createBookmark(User user, HouseOnSale houseOnSale){
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setHouseOnSale(houseOnSale);
        return bookmark;
    }
    public static BookmarkDto toDto(Bookmark entity){
        BookmarkDto dto = new BookmarkDto();
        dto.setBookmarkId(entity.getBookmarkId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setHouseOnSaleId(entity.getHouseOnSale().getHouseOnSaleId());

        return dto;
    }

    public static Bookmark toEntity(BookmarkDto dto, User user, HouseOnSale houseOnSale) {
        Bookmark entity = Bookmark.builder()
                .bookmarkId(dto.getBookmarkId())
                .user(user)
                .houseOnSale(houseOnSale)
                .build();

        return entity;
    }
}
