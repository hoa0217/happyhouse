export default interface MapListRs {
    houseInfoDtoList : houseInfoDto[];
}

export interface houseInfoDto {
    buildYear : string,
    dongCode : string,
    houseInfoId : Number,
    houseName : string,
    houseType : string,
    jibun : string,
    jibunAddress : string,
}