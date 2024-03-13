package com.learning.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

@Schema(description = "统一返回结果")
public class ReturnMessage<T> {
    @Schema(description = "错误码，0为成功")
    private int code;
    @Schema(description = "描述，错误时描述错误原因")
    private String msg;
    @Schema(description = "数据")
    private T data;

    public ReturnMessage() {
    }

    public ReturnMessage(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ReturnMessage<T> success(T t, String msg) {
        return new ReturnMessage<>(HttpStatus.OK.value(), msg, t);
    }

    public static <T> ReturnMessage<T> success(T t) {
        return success(t, HttpStatus.OK.getReasonPhrase());
    }

    public static <T> ReturnMessage<T> fail(int code, String msg) {
        return new ReturnMessage<>(code, msg, null);
    }

    public static <T> ReturnMessage<T> fail(HttpStatus errorCode) {
        return fail(errorCode.value(), errorCode.getReasonPhrase());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
