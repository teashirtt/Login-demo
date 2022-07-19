package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select password from login_user where username = #{username}")
    String GetPassword(String username);

    @Select("select username from login_user where username = #{username}")
    String GetUsername(String username);

    @Insert("insert into login_user values (null,#{username},#{password})")
    void add(User user);

}
