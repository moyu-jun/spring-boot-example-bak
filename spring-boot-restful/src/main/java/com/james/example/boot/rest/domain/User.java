package com.james.example.boot.rest.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类，对应数据库-用户表
 *
 * @author James
 * @date 2020/5/25
 */
@Data
@EqualsAndHashCode
@ToString
public class User {

    private Long id;

    private String username;

    private String password;

    /**
     * 性别，1：男性，2：女性，0：未知
     */
    private Byte sex;

    /**
     * 用户所属机构的 ID
     */
    private Long deptId;
}
