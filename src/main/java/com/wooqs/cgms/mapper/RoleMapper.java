package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Role;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role WHERE role_id = #{id}")
    Role getById(@Param("id") Long id);

    @Select("SELECT * FROM role")
    List<Role> getAll();

    @Insert("INSERT INTO role(role_name) VALUES(#{roleName})")
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    void insert(Role role);

    @Update("UPDATE role SET role_name = #{roleName} WHERE role_id = #{roleId}")
    void update(Role role);

    @Delete("DELETE FROM role WHERE role_id = #{id}")
    void deleteById(@Param("id") Long id);
}

