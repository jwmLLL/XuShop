package com.sxx.demo.model.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    protected int code;//0 成功
    protected String message;
    protected T data;
    protected int status;// 0成功

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
