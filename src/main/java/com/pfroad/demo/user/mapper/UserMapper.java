package com.pfroad.demo.user.mapper;

import java.util.List;

import com.pfroad.demo.user.provider.UserSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.pfroad.demo.user.entity.User;

@Mapper
public interface UserMapper {
	@Select("select * from user where username = #{username}")
	List<User> findByUsername(@Param("username") String username);
	
	@InsertProvider(type = UserSqlProvider.class, method = "insertSql")
	int save(User user);
	
	@SelectProvider(type = UserSqlProvider.class, method = "getSql")
	User get(Long id);
}
