package org.orechou.fast.common.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.orechou.fast.common.annotation.IsMobile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author OreChou
 * @date 2021/07/30
 */
@Data
@TableName("t_user")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    // 用户状态：有效
    public static final String STATUS_VALID = "1";
    // 用户状态：锁定
    public static final String STATUS_LOCK = "0";
    // 默认头像
    public static final String DEFAULT_AVATAR = "default.jpg";
    // 默认密码
    public static final String DEFAULT_PASSWORD = "1234qwer";
    // 性别男
    public static final String SEX_MALE = "0";
    // 性别女
    public static final String SEX_FEMALE = "1";
    // 性别保密
    public static final String SEX_UNKNOWN = "2";

    /**
     * 用户 ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("username")
    @Size(min = 4, max = 10, message = "{range}")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 部门 ID
     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 邮箱
     */
    @TableField("email")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String email;

    /**
     * 联系电话
     */
    @TableField("mobile")
    @IsMobile(message = "{mobile}")
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @TableField("status")
    @NotBlank(message = "{required}")
    private String status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 性别 0男 1女 2 保密
     */
    @TableField("ssex")
    private String sex;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 描述
     */
    @TableField("description")
    @Size(max = 100, message = "{noMoreThan}")
    private String description;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String createTimeFrom;
    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String roleName;

}
