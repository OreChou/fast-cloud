package org.orechou.fast.common.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.common.entity.FastConstant;
import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.util.FastUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author OreChou
 * @date 2021/07/28
 */
public class FastServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(FastConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(FastConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            FastResponse fastResponse = new FastResponse();
            FastUtils.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_FORBIDDEN,
                    fastResponse.message("请通过网关获取资源"));
            return false;
        }
    }
}
