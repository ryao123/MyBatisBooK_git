package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.book.BookService;
import service.book.impl.BookServiceImpl;

/**
 * Servlet implementation class look
 */
@WebServlet("/findByid")
public class findByid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();      
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findByid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ַ�����
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
			
		//���id
		int id=Integer.parseInt(req.getParameter("id"));
		
		List<Book> bid=bs.findByid(id);
		if (bid!=null) {
			req.setAttribute("bid",bid);
			req.getRequestDispatcher("update.jsp").forward(req,resp);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
