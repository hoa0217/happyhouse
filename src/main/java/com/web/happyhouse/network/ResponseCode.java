package com.web.happyhouse.network;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode{

    OK(200,"OK"),
    CREATED(201,"CREATED"),
    NO_CONTENT(204,"NO_CONTENT"),
    BAD_REQUEST(400,"BAD_REQUEST"),
    UNAUTHORIZED(401,"UNAUTHORIZED"),
    FORBIDDEN(403,"FORBIDDEN"),
    NOT_FOUND(404,"NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR"),
    SERVICE_UNAVAILABLE(503,"SERVICE_UNAVAILABLE"),
    DB_ERROR(600,"DB_ERROR");

    private final int code;
    private final String msg;

}
