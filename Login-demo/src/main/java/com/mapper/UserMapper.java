package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select password from login_user where username = #{username}")
    String GetPassword(String username);
}
