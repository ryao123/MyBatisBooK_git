package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.Pager;
import service.book.BookService;
import service.book.impl.BookServiceImpl;
import service.user.UserService;
import service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private BookService bs=new BookServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//获取页面pageIndex的值
		String pageIndex=req.getParameter("pageIndex");
		int currpage=1;
		//分页对象
		Pager pg=new Pager();
		//数据总条数
		int totalCount=bs.getCount();
		pg.setTotalCount(totalCount);
		if (pageIndex==null || "".equals(pageIndex)) {
			currpage=1;
		}else {
			int num=Integer.parseInt(pageIndex);
			if (num<=0) {
				currpage=1;
			}else if (num>pg.getTotalPages()) {
				currpage=pg.getTotalPages();
			}else {
				currpage=num;
			}
		}
		
		pg.setCurrPage(currpage);
		int from=(currpage-1)*pg.getPageSize();
		List pageLists=bs.getPageLists(from, pg.getPageSize());
		
		pg.setPageLists(pageLists);
		req.getSession().setAttribute("pg",pg);
		
		 //List<Book> list=bs.getList(); req.getSession().setAttribute("blist", list);
		 resp.sendRedirect("index.jsp");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
