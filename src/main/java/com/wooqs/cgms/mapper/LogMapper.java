package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Log;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface LogMapper {

    @Select("SELECT * FROM log WHERE log_id = #{id}")
    Log getById(@Param("id") Long id);

    @Select("SELECT * FROM log")
    List<Log> getAll();

    @Insert("INSERT INTO log(user_id, type, description) VALUES(#{userId}, #{type}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "logId")
    void insert(Log log);

    @Delete("DELETE FROM log WHERE log_id = #{id}")
    void deleteById(@Param("id") Long id);
}

