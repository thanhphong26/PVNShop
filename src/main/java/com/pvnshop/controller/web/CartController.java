package com.pvnshop.controller.web;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.models.CartModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.impl.CartServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = {"/cart","/deleteCart"})
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static ICartService cartS = new CartServiceImpl();
	private static IProductService pS = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("cart")) {
			HttpSession session = req.getSession();
			//String user = (String) session.getAttribute("username");
			String user = "user01";
			List<CartModel> list = cartS.findByUser(user);
			List<List<Object>> obs = new ArrayList<List<Object>>();
			for (CartModel cartModel : list) {
				int pID= cartModel.getProductID();
				ProductModel pmodel = pS.findByID(pID);
				List<Object> o = new ArrayList<Object>();
				o.add(pmodel.getProductID());
				o.add(pmodel.getProductName());
				int price = pmodel.getPrice();
				Locale vietnameseLocale = new Locale("vi", "VN");
		        NumberFormat vietnameseCurrencyFormat = NumberFormat.getCurrencyInstance(vietnameseLocale);
		        String vietnameseCurrency = vietnameseCurrencyFormat.format(price);
		        o.add(vietnameseCurrency);
		        o.add(pmodel.getImage());
				obs.add(o);
			}
			req.setAttribute("listp", obs);
			req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		}
		else if(url.contains("deleteCart")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cartS.delete(id);
			resp.sendRedirect(req.getContextPath()+"/cart");
		}
	}
}
