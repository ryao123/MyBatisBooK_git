package Dao.user;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//µÇÂ¼
	int login(@Param("name") String name,  @Param("password") String password);
}
