package service.book.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Dao.book.BookMapper;
import commons.MyBatisUtils;
import entity.Book;
import service.book.BookService;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession;
	//显示图书信息
	@Override
	public List<Book> getList() {
		sqlSession=MyBatisUtils.createSqlSession();
		List<Book> list=sqlSession.getMapper(BookMapper.class).getList();
		sqlSession.close();
		return list;
	}
	//添加图书信息
	@Override
	public boolean Add(Book book) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).Add(book);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	
	//删除图书信息
	@Override
	public boolean deleteByid(int id) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).deleteByid(id);
		System.out.println(num);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	
	//获得图书信息
	@Override
	public List<Book> findByid(int id) {
		sqlSession=MyBatisUtils.createSqlSession();
		List<Book> list=sqlSession.getMapper(BookMapper.class).findByid(id);
		sqlSession.close();
		return list;
	}
	
	//修改图书信息
	@Override
	public boolean update(Book book) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).update(book);
		System.out.println(num);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	
	@Override
	public int getCount() {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).getCount();
		MyBatisUtils.close(sqlSession);
		return num;
	}

	@Override
	public List getPageLists(int currPage, int pageSize) {
		sqlSession = MyBatisUtils.createSqlSession();
		List<Book> pageLists = sqlSession.getMapper(BookMapper.class).getPageLists(currPage,pageSize);
		MyBatisUtils.close(sqlSession);
		return pageLists;
	}
	
}
