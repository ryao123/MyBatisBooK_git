package service.book;

import java.util.List;

import entity.Book;

public interface BookService {
	//��ʾͼ����Ϣ
	List<Book> getList();

	//���ͼ����Ϣ
	boolean Add(Book book);

	//ɾ��ͼ����Ϣ
	boolean deleteByid(int id);

	//���ͼ����Ϣ
	List<Book> findByid(int id);

	//�޸�ͼ����Ϣ
	boolean update(Book book);

	int getCount();
	
	List getPageLists(int from, int pageSize);

	

}
