package com.woniu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.bean.Users;

@Mapper
public interface UserMaper {
	
	@Select("select user_id,username from users")
	List<Users> Select(int age);
}
