package org.orechou.fast.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.orechou.fast.common.entity.system.SystemUser;

/**
 * @author OreChou
 * @date 2021/07/30
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}