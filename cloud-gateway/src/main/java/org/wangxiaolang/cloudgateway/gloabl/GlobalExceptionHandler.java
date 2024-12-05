package org.wangxiaolang.cloudgateway.gloabl;

import cn.dev33.satoken.exception.NotPermissionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangxiaolang.common.R;

/**
 * @author wangzuoyu
 * @date 2024年11月11日 17:23
 * @description：全局权限校验异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String NO_PERMISSION_CODE = "405";

    @ExceptionHandler(value = {NotPermissionException.class})
    @ResponseBody
    public R handleMyException(NotPermissionException e){
        return R.fail(NO_PERMISSION_CODE, e.getMessage());
    }
}
