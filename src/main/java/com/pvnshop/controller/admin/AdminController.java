package com.pvnshop.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.dao.impl.ManufacturerDAOImpl;
import com.pvnshop.models.CategoryModel;
import com.pvnshop.models.ManufacturerModel;
import com.pvnshop.models.OrderModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IManufacturerService;
import com.pvnshop.service.IOrderService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ManufacturerServiceImpl;
import com.pvnshop.service.impl.OrderServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin_page", "/admin_page/SanPham", "/admin_page/HoaDon", "/admin_page/User",
		"/admin_page/ThongKe", "/admin_page/ThongKeDT", "/admin_page/ThemSanPham", "/admin_page/XoaSanPham", "/admin_page/SuaSanPham" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IProductService pro = new ProductServiceImpl();
	private static IOrderService or = new OrderServiceImpl();
	private static IUserService us = new UserServiceImpl();
	private static ICategoryService cate = new CategoryServiceImpl();
	private static IManufacturerService manu = new ManufacturerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admin_page/ThongKeDT")) {
			tkdt(req, resp);

		} else if (url.contains("admin_page/ThongKe")) {
			tkbc(req, resp);

		} else if (url.contains("admin_page/User")) {
			findAllUs(req, resp);

		} else if (url.contains("admin_page/HoaDon")) {
			findAllHD(req, resp);

		} else if (url.contains("admin_page/SanPham")) {
			findAllAd(req, resp);
		} else if (url.contains("admin_page/ThemSanPham")) {
			Insert(req,resp);
		}else if(url.contains("admin_page/XoaSanPham"))
		{
			Delete(req, resp);
		}else if(url.contains("admin_page/SuaSanPham"))
		{
			Update(req,resp);
		}
		else if (url.contains("admin_page")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("admin_page/ThemSanPham"))
		{
			InsertPost(req, resp);
		}else if(url.contains("admin_page/SuaSanPham"))
		{
			UpdatePost(req,resp);
		}
	}
	
	private void UpdatePost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String version = req.getParameter("version");
		String description = req.getParameter("description");
		int price = Integer.parseInt(req.getParameter("price"));
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		int inventory = Integer.parseInt(req.getParameter("inventory"));
		String image = req.getParameter("image");
		int cate_id = Integer.parseInt(req.getParameter("category"));
		int manu_id = Integer.parseInt(req.getParameter("manufacturer"));
		int id = Integer.parseInt(req.getParameter("productID"));
		ProductModel model = new ProductModel();
		model.setProductID(id);
		model.setProductName(productName);
		model.setVersion(version);
		model.setDescription(description);
		model.setPrice(price);
		model.setColor(color);
		model.setSize(size);
		model.setInventory(inventory);
		model.setImage(image);
		model.setCateID(cate_id);
		model.setManuID(manu_id);
		
		pro.UpdateProduct(model);
		resp.sendRedirect("SanPham");		
	}

	private void InsertPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String version = req.getParameter("version");
		String description = req.getParameter("description");
		int price = Integer.parseInt(req.getParameter("price"));
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		int inventory = Integer.parseInt(req.getParameter("inventory"));
		String image = req.getParameter("image");
		int cate_id = Integer.parseInt(req.getParameter("category"));
		int manu_id = Integer.parseInt(req.getParameter("manufacturer"));
		int id = pro.CreateProductID();
		ProductModel model = new ProductModel();
		model.setProductID(id);
		model.setProductName(productName);
		model.setVersion(version);
		model.setDescription(description);
		model.setPrice(price);
		model.setColor(color);
		model.setSize(size);
		model.setInventory(inventory);
		model.setImage(image);
		model.setCateID(cate_id);
		model.setManuID(manu_id);
		
		pro.InsertProduct(model);
		resp.sendRedirect("SanPham");
	}


	private void Insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listCategory", cate.findAll());
		req.setAttribute("listManufacturer", manu.findAll());
		req.getRequestDispatcher("/views/admin/insertsp.jsp").forward(req, resp);
	}
	
	private void Delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		int productID = Integer.parseInt(req.getParameter("ProductID"));
		pro.DeleteProduct(productID);
		resp.sendRedirect("SanPham");
	}

	private void Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int productID = Integer.parseInt(req.getParameter("ProductID"));
		req.setAttribute("Product", pro.findByID(productID));
		req.setAttribute("listCategory", cate.findAll());
		req.setAttribute("listManufacturer", manu.findAll());
		req.getRequestDispatcher("/views/admin/updatesp.jsp").forward(req, resp);
	}

	private void tkdt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int i = or.sum();
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
		List<ProductModel> i = pro.findAll();
		req.setAttribute("list1", i);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/spad.jsp");
		rd.forward(req, resp);

	}
}
