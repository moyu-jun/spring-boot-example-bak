package com.james.example.boot.rest.domain.response;

import com.james.example.boot.rest.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类扩展，添加一些额外参数，用于接口返回参数
 *
 * @author James
 * @date 2020/5/25
 */
@Data
@EqualsAndHashCode
@ToString
public class UserResponse extends User {

    /**
     * 用户实体类之外的额外参数
     *
     * 机构名称
     */
    private String deptName;

    public UserResponse(User user){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setDeptId(user.getDeptId());
        this.setSex(user.getSex());
    }
}
