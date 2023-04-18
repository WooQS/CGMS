package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE userId = #{id}")
    User getById(@Param("id") Long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getByUsername(@Param("username") String username);

    @Select("SELECT * FROM user WHERE username REGEXP #{username}")
    List<User> search(@Param("username") String username);

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Insert("INSERT INTO user(username, password, name, phone, email, roleId) " +
            "VALUES(#{username}, #{password}, #{name}, #{phone}, #{email}, #{roleId})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insert(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, name = #{name}, " +
            "phone = #{phone}, email = #{email}, lastLoginTime=#{lastLoginTime}, roleId = #{roleId} WHERE userId = #{userId}")
    @Options(useGeneratedKeys = false)
    void update(User user);

    @Delete("DELETE FROM user WHERE userId = #{id}")
    void deleteById(@Param("id") Long id);
}