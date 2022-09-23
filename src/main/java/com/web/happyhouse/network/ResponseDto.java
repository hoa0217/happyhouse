package com.web.happyhouse.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseDto<T> {

    private ResponseCode responseCode;
    private String message;
    private T data;

    public ResponseDto(ResponseCode responseCode){
        this.responseCode = responseCode;
        this.message = responseCode.getMsg();
        this.data = null;
    }

    public ResponseDto(ResponseCode responseCode, String message){
        this.responseCode = responseCode;
        this.message = message;
        this.data = null;
    }

    public static<T> ResponseDto<T> res(ResponseCode responseCode){
        return res(responseCode, responseCode.getMsg(),null);
    }

    public static<T> ResponseDto<T> res(ResponseCode responseCode, String message){
        return res(responseCode, message,null);
    }

    public static<T> ResponseDto<T> res(ResponseCode responseCode, T t){
        return res(responseCode, responseCode.getMsg(), t);
    }

    public static<T> ResponseDto<T> res(ResponseCode responseCode, String message, T t){
        return ResponseDto.<T>builder()
                .data(t)
                .responseCode(responseCode)
                .message(message)
                .build();
    }
}
