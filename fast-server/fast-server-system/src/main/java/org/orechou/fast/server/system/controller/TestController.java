package org.orechou.fast.server.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@RestController
public class TestController {

    @GetMapping("info")
    public String test(){
        return "febs-server-system";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }

}