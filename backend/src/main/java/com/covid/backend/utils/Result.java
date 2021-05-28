package com.covid.backend.utils;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.UUID;

@Data
public class Result<T> {
    private Boolean success;
    private int code;
    private String message;
    private String requestId;
    private String timestamp;
    private String totalCount;
    private T data;

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;
    public static final int CODE_VALIDATE_FAILED = 405;
    public static final int CODE_NOT_FOUND = 404;
    public static final int CODE_UNAUTHORIZED = 401;
    public static final int CODE_FORBIDDEN = 403;

    public Result() {
        this(200, "ok");
    }

    public Result(int code, String message) {
        this.success = code == 200;
        this.code = code;
        this.message = message;
        this.timestamp = TimeUtils.getISODateTime();
        this.requestId = UUID.randomUUID().toString().replaceAll("-", "");
        this.totalCount = "N/A";
    }

    public Result(int code, T dataObject, String message) {
        this(code, message);
        this.data = dataObject;
    }

    public static Result error(String message) {
        return new Result(CODE_ERROR, message);
    }

//    public static Result error(int code, String message) {
//        return new Result(code, message);
//    }

//    public static Result error(int code, String message, Object dataObject) {
//        return new Result(code, dataObject, message);
//    }

    public static Result error(String message, Object dataObject) {
        return new Result(CODE_ERROR, dataObject, message);
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Object dataObject) {
        return new Result(CODE_SUCCESS, dataObject, "ok");
    }

    public static Result pagedOk(Object dataObject, long total) {
        Result r = new Result(CODE_SUCCESS, dataObject, "ok");
        r.totalCount = Long.toString(total);
        return r;
    }

    public static Result pagedOk(Page page) {
        Result r = new Result(CODE_SUCCESS, page, "ok");
        r.totalCount = Long.toString(page.getTotal());
        return r;
    }

    public T getData() {
        return this.data;
    }
}
