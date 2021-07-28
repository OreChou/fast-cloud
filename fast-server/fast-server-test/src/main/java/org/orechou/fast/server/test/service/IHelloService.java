package org.orechou.fast.server.test.service;

import org.orechou.fast.common.entity.FastServerConstant;
import org.orechou.fast.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@FeignClient(value = FastServerConstant.Fast_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}