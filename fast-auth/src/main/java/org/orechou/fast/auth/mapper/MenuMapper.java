package org.orechou.fast.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.orechou.fast.common.entity.system.Menu;

import java.util.List;

/**
 * @author OreChou
 * @date 2021/07/30
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String username);
}
