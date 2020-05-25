package com.james.example.boot.hello.domain.request;

import com.james.example.boot.hello.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类扩展，添加一些额外参数，用于接口请求接收参数
 *
 * @author James
 * @date 2020/5/25
 */
@Data
@EqualsAndHashCode
@ToString
public class UserRequest extends User {

    /**
     * 关键词，用于搜索数据时
     */
    private String keyword;

    /**
     * 分页时的分页页数
     */
    private Integer pageNo;

    /**
     * 分页时的每页数据量
     */
    private Integer pageSize;

}
