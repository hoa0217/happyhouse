package com.web.happyhouse.bookmark.entity;

import com.web.happyhouse.bookmark.dto.BookmarkDto;
import com.web.happyhouse.bookmark.dto.BookmarkVillaDto;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOnSaleVilla;
import com.web.happyhouse.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookmarkVilla {

    @Id @GeneratedValue
    @Column(name = "bookmark_villa_id")
    private Long bookmarkVillaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_on_salWe_villa_id")
    private HouseOnSaleVilla houseOnSaleVilla;

    @Builder
    public BookmarkVilla(Long bookmarkVillaId, User user, HouseOnSaleVilla houseOnSaleVilla) {
        this.bookmarkVillaId = bookmarkVillaId;
        this.user = user;
        this.houseOnSaleVilla = houseOnSaleVilla;
    }

    public static BookmarkVilla createBookmark(User user, HouseOnSaleVilla houseOnSaleVilla){
        BookmarkVilla bookmarkVilla = new BookmarkVilla();
        bookmarkVilla.setUser(user);
        bookmarkVilla.setHouseOnSaleVilla(houseOnSaleVilla);
        return bookmarkVilla;
    }
    public static BookmarkVillaDto toDto(BookmarkVilla entity){
        BookmarkVillaDto dto = new BookmarkVillaDto();
        dto.setBookmarkVillaId(entity.getBookmarkVillaId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setHouseOnSaleVillaId(entity.getHouseOnSaleVilla().getHouseOnSaleVillaId());

        return dto;
    }

    public static BookmarkVilla toEntity(BookmarkVillaDto dto, User user, HouseOnSaleVilla houseOnSaleVilla) {
        BookmarkVilla entity = BookmarkVilla.builder()
                .bookmarkVillaId(dto.getBookmarkVillaId())
                .user(user)
                .houseOnSaleVilla(houseOnSaleVilla)
                .build();

        return entity;
    }
}
