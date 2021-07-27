package org.orechou.fast.auth.controller;

import org.apache.commons.lang3.StringUtils;
import org.orechou.fast.common.entity.FastResponse;
import org.orechou.fast.common.exception.FastAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public FastResponse signout(HttpServletRequest request) throws FastAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        FastResponse fastResponse = new FastResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new FastAuthException("退出登录失败");
        }
        return fastResponse.message("退出登录成功");
    }

}
