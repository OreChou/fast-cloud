package org.orechou.fast.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.exception.FastAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FastResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new FastResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = FastAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FastResponse handleFastAuthException(FastAuthException e) {
        log.error("系统错误", e);
        return new FastResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public FastResponse handleAccessDeniedException(){
        return new FastResponse().message("没有权限访问该资源");
    }

}
