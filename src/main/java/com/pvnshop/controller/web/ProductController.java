package com.pvnshop.controller.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pvnshop.models.CategoryModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.RateModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.ICategoryService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.impl.CartServiceImpl;
import com.pvnshop.service.impl.CategoryServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.RateServiceImpl;

@WebServlet(urlPatterns =  {"/product","/detailProduct", "/addReview"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductService productService=new ProductServiceImpl();
	ICategoryService cateService=new CategoryServiceImpl();
	ICartService cartService=new CartServiceImpl();
	IRateService rateService = new RateServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		if(url.contains("product")) {
			findAll(req, resp);
			
		}
		else if(url.contains("detailProduct")) {
			detailProduct(req, resp);
		}
		else if(url.contains("addReview")) {
			resp.sendRedirect(req.getContextPath() + "/detailProduct?id=" +req.getParameter("id"));
		}
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		String productID = "1";
		if(url.contains("addReview")) {
			Cookie arr[] =  req.getCookies();
			if(arr != null) {
				for(Cookie o : arr) {
					if(o.getName().equals("idc")) {
						productID = o.getValue();
					}
				}
			}
		if(productID!=null && !productID.isEmpty()) {
			try {
				int productId=Integer.parseInt(productID);
				RateModel RateModel =new RateModel();
				
				RateModel.setUsername(req.getParameter("username"));
				RateModel.setProductID(productId);
				RateModel.setStart(Integer.parseInt(req.getParameter("rating")));
				RateModel.setContext(req.getParameter("context"));
				
				rateService.insert(RateModel);
				System.out.println(RateModel.getUsername());
				resp.sendRedirect(req.getContextPath() + "/detailProduct?id=" + productID);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
			req.setAttribute("seactive", cateID);
		}
		
		//req.setAttribute("listProduct", listProduct);
		req.setAttribute("listCate", listCategory);
		req.setAttribute("setactive", cateID);
		req.setAttribute("bestSellerProduct", bestSellerProduct);
		req.setAttribute("lastestProduct", lastestProduct);

		req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);

	}
	private void detailProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("id");
		 Cookie userCookie = new Cookie("idc", ids);
         userCookie.setMaxAge(100); 
         resp.addCookie(userCookie);
        int id = Integer.parseInt(ids);
		ProductModel detailPro = productService.findByID(id);
		CategoryModel catePro = cateService.findById(detailPro.getCateID());
		List<RateModel> ratePro = rateService.findById(id);
		String cateId =  String.valueOf(catePro.getCateID());
		List<ProductModel> listProductByCategory=productService.findProductByCate(cateId);
		int allRate = rateService.countAll(id);

		int fiveStar = 0;
		int fourStar = 0;
		int threeStar = 0;
		int twoStar = 0;
		int oneStar = 0;
		int avgStar = 0;
		for (RateModel model : ratePro) {
			if(model.getStart() == 5)
				fiveStar++;
			else if(model.getStart() == 4)
				fourStar++;
			else if(model.getStart() == 3)
				threeStar++;
			else if(model.getStart() == 2)
				twoStar++;
			else
				oneStar++;
			
			avgStar+= model.getStart();
		}
		  DecimalFormat decimalFormat = new DecimalFormat("#.#");
	      String formattedNumber = decimalFormat.format((double)avgStar/ (double)ratePro.size());
	      double formatNumber = Double.parseDouble(formattedNumber);
	      
	      int fiveStarP = (int) Math.ceil(((double)fiveStar/ (double)ratePro.size())*100);
			int fourStarP = (int) Math.ceil(((double)fourStar/ (double)ratePro.size())*100);
			int threeStarP = (int) Math.ceil(((double)threeStar/ (double)ratePro.size())*100);
			int twoStarP = (int) Math.ceil(((double)twoStar/ (double)ratePro.size())*100);
			int oneStarP = (int) Math.ceil(((double)oneStar/ (double)ratePro.size())*100);
			
		  req.setAttribute("fiveStarP",fiveStarP);
	      req.setAttribute("fourStarP",fourStarP);
	      req.setAttribute("threeStarP",threeStarP);
	      req.setAttribute("twoStarP",twoStarP);
	      req.setAttribute("oneStarP",oneStarP);
	      req.setAttribute("fiveStar",fiveStar);
	      req.setAttribute("fourStar",fourStar);
	      req.setAttribute("threeStar",threeStar);
	      req.setAttribute("twoStar",twoStar);
	      req.setAttribute("oneStar",oneStar);
		req.setAttribute("avgStar",formatNumber);
		req.setAttribute("relatedProduct", listProductByCategory);
		req.setAttribute("ratePro", ratePro);
		req.setAttribute("catePro", catePro);
		req.setAttribute("allRate", allRate);
		req.setAttribute("detailPro", detailPro);
		req.getRequestDispatcher("/views/web/detailProduct.jsp").forward(req, resp);
		
	}
}
