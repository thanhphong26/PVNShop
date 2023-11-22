package com.pvnshop.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.UserModel;
import com.pvnshop.service.IOrderDetailService;
import com.pvnshop.service.IOrderService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.OrderDetailServiceImpl;
import com.pvnshop.service.impl.OrderServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = "/Account")
public class UserController extends HttpServlet{
	
	IUserService userSer = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	IOrderService orderSer = new OrderServiceImpl();
	IProductService productSer = new ProductServiceImpl();
	IOrderDetailService detailSer = new OrderDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("account");
		String name = user.getUsername();
		req.setAttribute("user", userSer.getOneUser(name));
		
		//System.out.println(detailSer.findAll());
		req.setAttribute("detail", detailSer.findAll());
		
		System.out.println(orderSer.findByUser(name));
		req.setAttribute("order", orderSer.findByUser(name));
		
		//System.out.println(productSer.findAll());
		req.setAttribute("product", productSer.findAll());
		req.getRequestDispatcher("/views/web/user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		UserModel model = new UserModel();
		model.setUsername(req.getParameter("username")); 
		model.setName(req.getParameter("name"));
		model.setPhone(req.getParameter("phone"));
		model.setEmail(req.getParameter("email"));
		model.setAddress(req.getParameter("address"));
		System.out.println(model.getAddress());
		model.setIsAdmin(Byte.parseByte(req.getParameter("isAdmin")));
		model.setPassword(req.getParameter("password"));
		userSer.update(model);
		//HttpSession session = req.getSession();
		//session.setAttribute("address", model.getAddress());
		//req.getRequestDispatcher("/views/web/user.jsp").forward(req, resp);
		resp.sendRedirect("Account");
	}
}
