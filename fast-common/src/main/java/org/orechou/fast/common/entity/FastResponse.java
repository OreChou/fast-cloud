package org.orechou.fast.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author OreChou
 * @date 2021/07/27
 */
@Data
public class FastResponse implements Serializable {

    private static final long serialVersionUID = 960902251323576923L;

    private int code;

    private String message;

    private Object data;

    public FastResponse message(String message) {
        this.message = message;
        return this;
    }

    public FastResponse data(Object data) {
        this.data = data;
        return this;
    }

}
