package zh.zh.mapper;


import org.apache.ibatis.annotations.*;
import zh.zh.entity.User;
import zh.zh.provider.UserProvider;

import java.util.List;
import java.util.Map;


@Mapper
	public interface UserMapper{
		@SelectProvider(type = UserProvider.class,method = "getAllUserDatas")
		List<Map<String,Object>> getAllUserDatas();

		@SelectProvider(type = UserProvider.class,method = "getUserSize")
		int getUserSize();

		    @SelectProvider(type = UserProvider.class,method = "getUserDataById")
			String getUserDataById(Integer id);

		    @Delete("delete from user where id=#{id}")
		    boolean deleteUserDataById(Integer id);

		    @UpdateProvider(type = UserProvider.class,method = "updateUserDataById")
		    boolean updateUserDataById(User user);

		    @Options(useGeneratedKeys = true,keyProperty = "id")//是指定主键生成的并且主键是id
		    @Insert("insert into user(name,gender,age,address,qq,email) values (#{name},#{gender},#{age},#{address},#{qq},#{email})")
		    boolean addUserData(User user);
	}

