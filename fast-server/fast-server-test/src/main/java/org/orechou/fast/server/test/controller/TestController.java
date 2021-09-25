package org.orechou.fast.server.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.orechou.fast.server.test.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private IHelloService helloService;

    @GetMapping("hello")
    public String hello(String name) {
        log.info("Feign 调用 fast-server-system 的 hello 服务");
        return helloService.hello(name);
    }

    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1(){
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2(){
        return "拥有'user:update'权限";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
