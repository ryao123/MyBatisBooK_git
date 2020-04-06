package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.user.UserService;
import service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us=new UserServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//获取登录页面的值
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		boolean isOk=us.login(name,password);
		req.getSession().setAttribute("name",name);
		String msg = null;
		if (isOk) {
			msg = "true";
			req.setAttribute("msg", msg);
			resp.sendRedirect("Index");
		}else {
			//登录提示
			 msg = "false";
			 req.setAttribute("msg", msg);
			resp.sendRedirect("login.jsp");
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
