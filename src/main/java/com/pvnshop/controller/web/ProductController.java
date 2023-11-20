package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.dao.ICategoryDAO;
import com.pvnshop.models.CategoryModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IRateService;
import com.pvnshop.service.impl.CartServiceImpl;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns =  {"/product","/product-detail"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductService productService=new ProductServiceImpl();
	ICategoryService cateService=new CategoryServiceImpl();
	ICartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("product")) {
			findAll(req, resp);
			
		}
	}	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cateID=req.getParameter("id");
		List<ProductModel> listProduct=productService.findAll();
		List<CategoryModel> listCategory=cateService.findAll();
		List <ProductModel> i = productService.findTop3();
		req.setAttribute("top3", i);
		req.setAttribute("listProduct", listProduct);
		List<ProductModel> listProductByCategory=productService.findProductByCate(cateID);
		List<ProductModel> bestSellerProduct=productService.findTop3();
		ProductModel lastestProduct=productService.getLastestProduct();
		if(cateID==null) {
			req.setAttribute("listProduct", listProduct);
		}else {
			req.setAttribute("listProduct",  listProductByCategory);
		}
		
		//req.setAttribute("listProduct", listProduct);
		req.setAttribute("listCate", listCategory);
		req.setAttribute("bestSellerProduct", bestSellerProduct);
		req.setAttribute("lastestProduct", lastestProduct);
		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);

	}
}
