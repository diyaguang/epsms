package com.dygstudio.epsms.common;

import java.lang.annotation.*;

/**
 * @author: diyaguang
 * @date: 2018/02/28 上午9:38
 * @description: com.dygstudio.epsms.common
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
