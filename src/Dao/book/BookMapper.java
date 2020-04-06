package Dao.book;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Book;

public interface BookMapper {
	//��ʾͼ����Ϣ
	List<Book> getList();
	//���ͼ����Ϣ
	int Add(Book book);
	//ɾ��ͼ����Ϣ
	int deleteByid(@Param("id") int id);
	//���ͼ����Ϣ
	List<Book> findByid(@Param("id") int id);
	//�޸�ͼ����Ϣ
	int update(Book book);
	
	
	int getCount();
	
	List<Book> getPageLists(@Param("from") int currPage,@Param("pageSize") int pageSize);

}
