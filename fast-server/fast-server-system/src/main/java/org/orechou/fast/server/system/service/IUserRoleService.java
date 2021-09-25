package org.orechou.fast.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.orechou.fast.common.entity.system.UserRole;

/**
 * @author OreChou
 * @date 2021/09/24
 */
public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
