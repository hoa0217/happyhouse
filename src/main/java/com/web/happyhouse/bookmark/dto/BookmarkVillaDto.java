package com.web.happyhouse.bookmark.dto;

import com.web.happyhouse.base.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel("북마크(관심매물) 정보")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookmarkVillaDto extends BaseDto {

    @ApiModelProperty(value="북마크(관심 매물) ID", example = "1")
    private Long bookmarkVillaId;

    @ApiModelProperty(value = "해당 매물에 관심있는 userId")
    private Long userId;

    @ApiModelProperty(value = "매물 정보Id")
    private Long houseOnSaleVillaId;

}
