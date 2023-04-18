package com.wooqs.cgms.mapper;

import com.wooqs.cgms.model.Log;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface LogMapper {

    @Select("SELECT * FROM log WHERE userId REGEXP #{id}")
    List<Log> getByUserId(@Param("id") Long id);

    @Select("SELECT * FROM log")
    List<Log> getAll();

    @Insert("INSERT INTO log(userId, type, description) VALUES(#{userId}, #{type}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "logId")
    void insert(Log log);

    @Delete("DELETE FROM log WHERE logId = #{id}")
    void deleteById(@Param("id") Long id);
}

