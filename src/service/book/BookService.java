package service.book;

import java.util.List;

import entity.Book;

public interface BookService {
	//显示图书信息
	List<Book> getList();

	//添加图书信息
	boolean Add(Book book);

	//删除图书信息
	boolean deleteByid(int id);

	//获得图书信息
	List<Book> findByid(int id);

	//修改图书信息
	boolean update(Book book);

	int getCount();
	
	List getPageLists(int from, int pageSize);

	

}
