package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Community;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select("SELECT * FROM community WHERE community_id = #{id}")
    Community getById(@Param("id") Long id);

    @Select("SELECT * FROM community")
    List<Community> getAll();

    @Insert("INSERT INTO community(name, admin_id, address) VALUES(#{name}, #{adminId}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "communityId")
    void insert(Community community);

    @Update("UPDATE community SET name = #{name}, admin_id = #{adminId}, address = #{address}, update_time = CURRENT_TIMESTAMP(0) WHERE community_id = #{communityId}")
    void update(Community community);

    @Delete("DELETE FROM community WHERE community_id = #{id}")
    void deleteById(@Param("id") Long id);
}

