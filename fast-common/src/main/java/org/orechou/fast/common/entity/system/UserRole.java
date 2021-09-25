package org.orechou.fast.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author OreChou
 * @date 2021/09/24
 */
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 2614950767458378791L;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Long roleId;

}
