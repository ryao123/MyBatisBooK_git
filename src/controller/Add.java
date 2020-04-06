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
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		
		//获取页面数据
		String  name=req.getParameter("name");
		String  author=req.getParameter("author");
		String  publish=req.getParameter("publish");
		String publishdate=req.getParameter("publishdate");
		int page=Integer.parseInt(req.getParameter("page"));
		double price=Double.parseDouble(req.getParameter("price"));
		String  content=req.getParameter("content");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Book book=new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPublish(publishdate);
		
		try {
			book.setPublishdate(sdf.parse(publishdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book.setPage(page);
		book.setPrice(price);
		book.setContent(content);
		
		boolean isOk=bs.Add(book);
		if (isOk) {
			resp.sendRedirect("Index");
		}else {
			resp.sendRedirect("add.jsp");
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
