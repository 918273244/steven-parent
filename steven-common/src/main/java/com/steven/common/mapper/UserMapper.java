package com.steven.common.mapper;

import com.steven.common.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * userMapper
 * Created by Steven on 2017/4/16.
 */
@Mapper
public interface UserMapper {

    /**
     * 通过username获取users
     * @param username
     * @return
     */
    @Select("select * from TESTUSER WHERE USERNAME =#{username}")
    public User findByUsername(@Param("username") String username);

    @Insert("insert into TESTUSER (USERNAME, USERPASSWORD, ROLE) values (#{username}, #{password}, #{role})")
    public int saveUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
