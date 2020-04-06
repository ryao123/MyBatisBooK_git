package service.user.impl;
import org.apache.ibatis.session.SqlSession;

import Dao.user.UserMapper;
import commons.MyBatisUtils;
import service.user.UserService;
public class UserServiceImpl implements UserService {

	private SqlSession sqlSession;
	@Override
	public boolean login(String name, String password) {
		sqlSession=MyBatisUtils.createSqlSession();
		int result=sqlSession.getMapper(UserMapper.class).login(name,password);
		if (result>0) {
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}

}
