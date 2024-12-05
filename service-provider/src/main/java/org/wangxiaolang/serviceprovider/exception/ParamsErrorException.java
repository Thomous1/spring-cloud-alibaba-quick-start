package org.wangxiaolang.serviceprovider.exception;


/**
 * @author wangzuoyu
 * @date 2024年12月04日 17:19
 * @description：自定义参数异常
 */
public class ParamsErrorException extends RuntimeException {

    public ParamsErrorException() {
        super();
    }
    public ParamsErrorException(String message) {
        super(message);
    }

    public ParamsErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
