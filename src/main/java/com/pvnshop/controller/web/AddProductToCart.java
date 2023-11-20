package com.pvnshop.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.CartModel;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.impl.CartServiceImpl;

@WebServlet(urlPatterns = "/add-to-cart")
public class AddProductToCart extends HttpServlet{
	private static final long serialVersionUID = 6561918161821778499L;
	ICartService cartService=new CartServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productID=req.getParameter("id");
		if(productID!=null && !productID.isEmpty()) {
			try {
				int productId=Integer.parseInt(productID);
				CartModel cart=new CartModel();
				HttpSession session=req.getSession();
				UserModel user = (UserModel) session.getAttribute("account");
				String username=user.getUsername();
				cart.setUsername(username);
				cart.setProductID(productId);
				cart.setQuantity(1);
				
				cartService.insert(cart);
				//resp.getWriter().write("Thêm sản phẩm vào giỏ hàng thành công");
				resp.sendRedirect("cart");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
