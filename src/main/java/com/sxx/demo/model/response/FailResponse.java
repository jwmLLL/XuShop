
package com.sxx.demo.model.response;

import org.apache.http.util.TextUtils;
import org.springframework.lang.Nullable;

public class FailResponse extends BaseResponse {
    public FailResponse(@Nullable String message) {
        if(TextUtils.isEmpty(message)){
            this.message = "faile";
        } else{
          this.message = message;
        }
        this.code = -1;
        this.status = 401;//token 失效

    }
}
