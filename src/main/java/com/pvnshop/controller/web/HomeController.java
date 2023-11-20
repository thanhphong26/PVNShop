package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.CategoryModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IRateService;
import com.pvnshop.service.ISearchService;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.RateServiceImpl;
import com.pvnshop.service.impl.SearchServiceImpl;
import com.pvnshop.service.impl.UserServiceImpl;
import com.pvnshop.util.constant;
@WebServlet(urlPatterns = {"/home","/login","/register","/waiting","/logout","/search"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = -3579095519001596408L;
	IUserService userService=new UserServiceImpl();
	IProductService proService=new ProductServiceImpl();
	IRateService rateService=new RateServiceImpl();
	ISearchService searchService=new SearchServiceImpl();
	ICategoryService cateService=new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getRequestURI().toString();
		if(url.contains("home")) {
			top3(req, resp);
		}
		else if(url.contains("login")) {
			getLogin(req, resp);
		}else if(url.contains("waiting")){
			getWaiting(req, resp);
		}else if(url.contains("logout")) {
			getLogout(req, resp);
		}
		else if(url.contains("register")) {
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		}else if(url.contains("search")) {
			searchByName(req, resp);
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
				if(cookie.getName().equals("user")) {
					session=req.getSession(true);
					session.setAttribute("user", cookie.getValue());
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
			System.out.println("hello");
			if(user.getIsAdmin()==0) {
				resp.sendRedirect("home");
			}else if(user.getIsAdmin()==1) {
				resp.sendRedirect("admin_page");
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
	private void top3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <ProductModel> i = proService.findTop3();
		req.setAttribute("top3", i);
		List <ProductModel> o = proService.findRateTop3();
		req.setAttribute("topr3", o);
		List <RateModel> e = rateService.ratetop3();
		req.setAttribute("toprate3", e);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
		
	}
	private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String txtsearch=req.getParameter("txt");
		List<ProductModel> listSearch=searchService.searchByName(txtsearch);
		List<ProductModel> bestSellerProduct=proService.findTop3();
		ProductModel lastestProduct=proService.getLastestProduct();
		List<CategoryModel> listCategory=cateService.findAll();

		req.setAttribute("listCate", listCategory);
		req.setAttribute("listSearch", listSearch);
		req.setAttribute("bestSellerProduct", bestSellerProduct);
		req.setAttribute("lastestProduct", lastestProduct);
		req.getRequestDispatcher("/views/web/product-search.jsp").forward(req, resp);
	}
}
