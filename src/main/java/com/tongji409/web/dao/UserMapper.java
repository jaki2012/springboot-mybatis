package com.tongji409.web.dao;

import com.tongji409.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lijiechu
 * @create on 16/12/3
 * @description
 */
@Mapper
public interface UserMapper {
    @Select("Select * from user where name = #{name}")
    User findUserByName(@Param("name") String name);

    @Insert("Insert into user values (#{id}, #{age}, #{name}, #{nickname})")
    int insert(@Param("id")int id, @Param("age")int age, @Param("name") String name, @Param("nickname")String nickname);
}

