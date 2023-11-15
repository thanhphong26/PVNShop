package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.models.OrderModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.IOrderService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IRateService;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.OrderServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.RateServiceImpl;
import com.pvnshop.service.impl.UserServiceImpl;




@WebServlet(urlPatterns =  {"/home","/admin_page",
		"/admin_page/SanPham","/admin_page/HoaDon","/admin_page/User","/admin_page/ThongKe","/admin_page/ThongKeDT"})
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IProductService pro = new ProductServiceImpl();
	private static IRateService rat = new RateServiceImpl();
	private static IOrderService or = new OrderServiceImpl();
	private static IUserService us = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("home")) {
			top3(req,resp);
			
		}else if(url.contains("admin_page/ThongKeDT")) {
			tkdt(req,resp);
			
		}else if(url.contains("admin_page/ThongKe")) {
			tkbc(req,resp);
			
		}else if(url.contains("admin_page/User")) {
			findAllUs(req,resp);
			
		}else if(url.contains("admin_page/HoaDon")) {
			findAllHD(req,resp);
			
		}else if(url.contains("admin_page/SanPham")) {
			findAllAd(req,resp);
			
		}else if(url.contains("admin_page")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);
		}
		
	}

	private void tkdt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int i= or.sum();
		req.setAttribute("sum", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tkdt.jsp");
		rd.forward(req, resp);
	}

	private void tkbc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> i = pro.findTop();
		req.setAttribute("listtk", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tkad.jsp");
		rd.forward(req, resp);
		
	}

	private void findAllUs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> i = us.getAllUser();
		req.setAttribute("listO", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/uad.jsp");
		rd.forward(req, resp);
		
	}

	private void findAllHD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> i = or.findAll();
		req.setAttribute("listO", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/hdad.jsp");
		rd.forward(req, resp);
		
	}

	private void findAllAd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> i = pro.findall();
		req.setAttribute("list1", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/spad.jsp");
		rd.forward(req, resp);
		
	}

	private void top3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <ProductModel> i = pro.findTop3();
		req.setAttribute("top3", i);
		List <ProductModel> o = pro.findRateTop3();
		req.setAttribute("topr3", o);
		List <RateModel> e = rat.ratetop3();
		req.setAttribute("toprate3", e);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
		
	}
}
