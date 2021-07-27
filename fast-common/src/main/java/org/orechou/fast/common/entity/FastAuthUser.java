package org.orechou.fast.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Data
public class FastAuthUser implements Serializable {

    private static final long serialVersionUID = -785791528924915678L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
