package org.wangxiaolang.serviceprovider.gloabl;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangxiaolang.common.R;
import org.wangxiaolang.exception.ParamsErrorException;

/**
 * @author wangzuoyu
 * @date 2024年11月11日 17:23
 * @description：异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String REQUEST_PARAM_ERROR_CODE = "505";

    @ExceptionHandler(value = {ParamsErrorException.class})
    @ResponseBody
    public R handleMyException(ParamsErrorException e){
        return R.fail(REQUEST_PARAM_ERROR_CODE, e.getMessage());
    }
}
