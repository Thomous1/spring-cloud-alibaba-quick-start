package com.creditease.microloan.users.black.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "返回信息")
public class R<T> implements Serializable {

    public R() {}
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码", required = true, example = "0000")
    private String status;
    @ApiModelProperty(value = "返回消息", required = true, example = "操作成功")
    private String msg;
    @ApiModelProperty(value = "业务数据")
    private T data;


    private R(String code, String msg) {
        this(code, msg, null);
    }
    private R(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<>("0000","操作成功");
    }

    /**
     * 返回R
     *
     * @param data       数据
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(T data) {
        return new R<>("0000","操作成功", data);
    }
    public static <T> R<T> fail(String code, String msg) {
        return new R<>(code, msg);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

