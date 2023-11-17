package com.pvnshop.controller.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns =  {"/Product"})
public class ListProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IProductService pro = new ProductServiceImpl();
	ICategoryService cate = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listproduct", pro.findall());
		req.setAttribute("listcategory", cate.findAll());
		
		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
