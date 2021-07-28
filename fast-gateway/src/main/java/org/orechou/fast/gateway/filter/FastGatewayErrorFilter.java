package org.orechou.fast.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.util.FastUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Slf4j
@Component
public class FastGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            FastResponse fastResponse = new FastResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            fastResponse = resolveExceptionMessage(message, serviceId, fastResponse);

            HttpServletResponse response = ctx.getResponse();
            FastUtils.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, fastResponse
            );
            log.error("Zuul sendError：{}", fastResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private FastResponse resolveExceptionMessage(String message, String serviceId, FastResponse fastResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return fastResponse.message("请求 " + serviceId + " 服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return fastResponse.message(serviceId + " 服务不可用");
        }
        return fastResponse.message("Zuul请求 " + serviceId + " 服务异常");
    }

}
