package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.models.CategoryModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.ISearchService;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.SearchServiceImpl;

@WebServlet(urlPatterns =  {"/search"})
public class SearchController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ISearchService sServ=new SearchServiceImpl();
	ICategoryService cateService=new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("search")) {
			searchByName(req, resp);
		}
	}
	private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String txtsearch=req.getParameter("txt");
		List<ProductModel> listSearch=sServ.searchByName(txtsearch);
		req.setAttribute("listSearch", listSearch);
		req.getRequestDispatcher("/views/web/search.jsp").forward(req, resp);
	}
}
