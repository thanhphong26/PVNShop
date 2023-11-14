package com.pvnshop.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.CartModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.impl.CartServiceImpl;


@WebServlet(urlPatterns = {"/cart","/deleteCart"})
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static ICartService cartS = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("cart")) {
			HttpSession session = req.getSession();
			String user = (String) session.getAttribute("username");
			List<CartModel> list = cartS.findByUser(user);
		}
	}
}
