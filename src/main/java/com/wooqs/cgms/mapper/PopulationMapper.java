package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Population;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PopulationMapper {

    @Select("SELECT * FROM population WHERE population_id = #{id}")
    Population getById(@Param("id") Long id);

    @Select("SELECT * FROM population")
    List<Population> getAll();

    @Insert("INSERT INTO population(community_id, name, gender, age, job, id_card, hometown, address) VALUES(#{communityId}, #{name}, #{gender}, #{age}, #{job}, #{idCard}, #{hometown}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "populationId")
    void insert(Population population);

    @Update("UPDATE population SET community_id = #{communityId}, name = #{name}, gender = #{gender}, age = #{age}, job = #{job}, id_card = #{idCard}, hometown = #{hometown}, address = #{address} WHERE population_id = #{populationId}")
    void update(Population population);

    @Delete("DELETE FROM population WHERE population_id = #{id}")
    void deleteById(@Param("id") Long id);
}

