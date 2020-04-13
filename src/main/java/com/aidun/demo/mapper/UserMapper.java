package com.aidun.demo.mapper;

import com.aidun.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    User selectByAccount(@Param("account") String account);
}
