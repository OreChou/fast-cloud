package org.orechou.fast.common.handler;

import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.util.FastUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OreChou
 * @date 2021/07/27
 */
public class FastAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        FastResponse fastResponse = new FastResponse();
        FastUtils.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_UNAUTHORIZED, fastResponse.message("token 无效"));
    }
}
