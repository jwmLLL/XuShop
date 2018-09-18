package com.sxx.demo.model.response;

import org.apache.http.util.TextUtils;
import org.springframework.lang.Nullable;

public class SuccessResponse<T> extends BaseResponse {
    public SuccessResponse(@Nullable String message) {
        if (!TextUtils.isEmpty(message)) {
            this.message = message;
        } else {
            this.message = "success";
        }
        this.code = 1;
        this.status = 1;
    }
}
