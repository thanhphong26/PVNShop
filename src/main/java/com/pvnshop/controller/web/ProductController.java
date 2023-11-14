package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IRateService;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.RateServiceImpl;




@WebServlet(urlPatterns =  {"/home"})
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IProductService pro = new ProductServiceImpl();
	private static IRateService rat = new RateServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("home")) {
			top3(req,resp);
		}
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
