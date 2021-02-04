package com.example.validation;

import javax.validation.constraints.Size;
import java.lang.annotation.*;

/**
 * 描述属性验证时对应的错误码
 * 例：@ErrorCode(code = ErrorCodeConst.DEVICE_NAME_ABOVE_LIMIT, type = Size.class)
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ErrorCode.List.class)
@Documented
public @interface ErrorCode {

    /**
     * 错误码
     */
    int code() default 1;

    /**
     * 校验类型，主要是来自javax.validation.constraints包下的验证约束类型，如：Size.class
     */
    Class<?> type() default Size.class;

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        ErrorCode[] value();
    }
}
