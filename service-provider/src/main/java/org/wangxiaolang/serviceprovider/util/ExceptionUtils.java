package org.wangxiaolang.serviceprovider.util;


import org.wangxiaolang.serviceprovider.exception.ParamsErrorException;

/**
 * @author wangzuoyu
 * @date 2024年11月05日 18:34
 * @description：异常处理
 */
public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static ParamsErrorException mpe(String msg, Throwable t, Object... params) {
        return new ParamsErrorException(String.format(msg, params), t);
    }

    public static ParamsErrorException mpe(String msg, Object... params) {
        return new ParamsErrorException(String.format(msg, params));
    }

    public static ParamsErrorException mpe(Throwable t) {
        return new ParamsErrorException(null,t);
    }

    public static void throwMpe(boolean condition, String msg, Object... params) {
        if (condition) {
            throw mpe(msg, params);
        }
    }
}
