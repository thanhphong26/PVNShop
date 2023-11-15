package com.pvnshop.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.UserModel;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.UserServiceImpl;
import com.pvnshop.util.constant;
@WebServlet(urlPatterns = {"/login","/register"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = -3579095519001596408L;
	IUserService userService=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getRequestURI().toString();
		if(url.contains("login")) {
			getLogin(req, resp);
		}else if(url.contains("waiting")){
			getWaiting(req, resp);
		}else if(url.contains("logout")) {
			getLogout(req, resp);
		}
		else if(url.contains("home")) {
			req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
		}
		else if(url.contains("register")) {
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getRequestURI().toString();
		if(url.contains("login")) {
			postLogin(req,resp);
		}else if(url.contains("register")) {
			postRegister(req, resp);
		}
	}
	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//check session
		HttpSession session=req.getSession();
		if(session!=null &&session.getAttribute("account")!=null) {
			resp.sendRedirect(req.getContextPath()+"/waiting");
			return;
		}
		//check cookies
		Cookie[] cookies=req.getCookies();
		if(cookies!=null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("email")) {
					session=req.getSession(true);
					session.setAttribute("email", cookie.getValue());
					resp.sendRedirect(req.getContextPath()+"/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String alert="";
	    if(username.isEmpty() || password.isEmpty()) {
	    	alert="Tài khoản hoặc mật khẩu không đúng";
	    	req.setAttribute("message", alert);
	    	req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	    	return;
	    }
	    UserModel user=userService.login(username, password);
	    if(user!=null) {
	    	HttpSession session=req.getSession();
	    	session.setAttribute("account", user);
	    	resp.sendRedirect(req.getContextPath()+"/waiting");
	    }else {
	    	alert="Tài khoản hoặc mật khẩu không đúng";
	    	req.setAttribute("message", alert);
	    	req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	    }
	}
	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session=req.getSession();
		if(session!=null &&session.getAttribute("account")!=null) {
			UserModel user=(UserModel) session.getAttribute("account");
			if(user.getIsAdmin()==0) {
				resp.sendRedirect("home");
			}else if(user.getIsAdmin()==1) {
				resp.sendRedirect("adminUser");
			}
		}else {
			resp.sendRedirect("login");
		}
	}
	private void getLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// Remove session attributes
		session.removeAttribute("account");
		// Process cookies
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0); // Remove the cookie
					resp.addCookie(cookie); // Update the response with the removed cookie
					break;
				}
			}
		}
		// Redirect to the login page AFTER handling cookies and session
		resp.sendRedirect(req.getContextPath() + "/login");
	}
	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String password=req.getParameter("password");

		String alertMsg = "";
		if (userService.checkExistUserEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		}
		else if (userService.checkExistUsername(username)) {
			alertMsg = "Tên đăng nhập đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		}
		else {
			if(userService.registerUser(username, name, phone, email, address, password)) {
				resp.sendRedirect("login");
			}
		}
	}
}
