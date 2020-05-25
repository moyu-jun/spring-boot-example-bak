package com.james.example.boot.rest.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
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
    private String nickName;
    private Byte sex;
}
