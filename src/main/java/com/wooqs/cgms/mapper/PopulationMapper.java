package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Population;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PopulationMapper {

    @Select("SELECT * FROM population WHERE populationId = #{id}")
    Population getById(@Param("id") Long id);

    @Select("SELECT * FROM population WHERE communityId = #{communityId}")
    List<Population> getByCommunityId(@Param("communityId") Long communityId);

    @Select("SELECT * FROM population WHERE name REGEXP #{name} AND communityId = #{communityId}")
    List<Population> search(@Param("name") String name, @Param("communityId") Long communityId);

    @Select("SELECT * FROM population")
    List<Population> getAll();

    @Insert("INSERT INTO population(communityId, name, gender, age, job, idCard, hometown, address) VALUES(#{communityId}, #{name}, #{gender}, #{age}, #{job}, #{idCard}, #{hometown}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "populationId")
    void insert(Population population);

    @Update("UPDATE population SET communityId = #{communityId}, name = #{name}, gender = #{gender}, age = #{age}, job = #{job}, idCard = #{idCard}, hometown = #{hometown}, address = #{address} WHERE populationId = #{populationId}")
    void update(Population population);

    @Delete("DELETE FROM population WHERE populationId = #{id}")
    void deleteById(@Param("id") Long id);
}

