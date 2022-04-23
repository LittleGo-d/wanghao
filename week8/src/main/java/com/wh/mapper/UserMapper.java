package com.wh.mapper;

import com.wh.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author whstart
 * @creat 2022--21-16:04
 */
public interface UserMapper {

    @Select("select * from user where name = #{name} and password = #{password}")
    User login(@Param("name") String name, @Param("password") String password);

    @Select("select * from user where name = #{name}")
    User selectByName(@Param("name")String name);

    @Update("update user set name = #{user.name},password = #{user.password} where id = #{user.id}")
    void update(@Param("user") User user);

}
