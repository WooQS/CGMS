package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Community;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select("SELECT * FROM community WHERE communityId = #{id}")
    Community getById(@Param("id") Long id);

    @Select("SELECT * FROM community WHERE adminId = #{AdminId}")
    List<Community> getByAdminId(@Param("AdminId") Long AdminId);

    @Select("SELECT * FROM community WHERE name REGEXP #{name}")
    List<Community> search(@Param("name") String name);

    @Select("SELECT * FROM community")
    List<Community> getAll();

    @Insert("INSERT INTO community(name, adminId, address) VALUES(#{name}, #{adminId}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "communityId")
    void insert(Community community);

    @Update("UPDATE community SET name = #{name}, adminId = #{adminId}, address = #{address}, updateTime = CURRENT_TIMESTAMP(0) WHERE communityId = #{communityId}")
    void update(Community community);

    @Delete("DELETE FROM community WHERE communityId = #{id}")
    void deleteById(@Param("id") Long id);
}

