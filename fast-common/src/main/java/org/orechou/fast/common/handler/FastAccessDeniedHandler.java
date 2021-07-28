package org.orechou.fast.common.handler;

import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.util.FastUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OreChou
 * @date 2021/07/27
 */
public class FastAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException {
        FastResponse fastResponse = new FastResponse();
        FastUtils.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_FORBIDDEN, fastResponse.message("没有权限访问该资源"));
    }
}
