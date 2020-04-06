package Dao.book;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Book;

public interface BookMapper {
	//显示图书信息
	List<Book> getList();
	//添加图书信息
	int Add(Book book);
	//删除图书信息
	int deleteByid(@Param("id") int id);
	//获得图书信息
	List<Book> findByid(@Param("id") int id);
	//修改图书信息
	int update(Book book);
	
	
	int getCount();
	
	List<Book> getPageLists(@Param("from") int currPage,@Param("pageSize") int pageSize);

}
