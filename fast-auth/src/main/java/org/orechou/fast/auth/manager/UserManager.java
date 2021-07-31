package org.orechou.fast.auth.manager;

import org.orechou.fast.auth.mapper.MenuMapper;
import org.orechou.fast.auth.mapper.UserMapper;
import org.orechou.fast.common.entity.system.Menu;
import org.orechou.fast.common.entity.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author OreChou
 * @date 2021/07/30
 */
@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        return menuMapper.findUserPermissions(username).stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }

}
