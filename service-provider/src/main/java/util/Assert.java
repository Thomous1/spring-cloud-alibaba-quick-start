package util;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author wangzuoyu
 * @date 2024年11月13日 18:33
 * @description：断言
 */
public class Assert {
    public Assert() {
    }

    public static void isTrue(boolean expression, String message, Object... params) {
        if (!expression) {
            throw ExceptionUtils.mpe(message, params);
        }
    }

    public static void isFalse(boolean expression, String message, Object... params) {
        isTrue(!expression, message, params);
    }

    public static void isNull(Object object, String message, Object... params) {
        isTrue(object == null, message, params);
    }

    public static void notNull(Object object, String message, Object... params) {
        isTrue(object != null, message, params);
    }

    public static void notEmpty(String value, String message, Object... params) {
        isTrue(StringUtils.isNotBlank(value), message, params);
    }

    public static void notEmpty(Collection<?> collection, String message, Object... params) {
        isTrue(CollectionUtils.isNotEmpty(collection), message, params);
    }

    public static void notEmpty(Map<?, ?> map, String message, Object... params) {
        isTrue(CollectionUtils.isNotEmpty(map), message, params);
    }

    public static void isEmpty(Map<?, ?> map, String message, Object... params) {
        isTrue(CollectionUtils.isEmpty(map), message, params);
    }

    public static void notEmpty(Object[] array, String message, Object... params) {
        isTrue(ArrayUtils.isNotEmpty(array), message, params);
    }
}
