package com.pvnshop.controller.web;

import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pvnshop.dao.IDiscountDAO;
import com.pvnshop.models.CartModel;
import com.pvnshop.models.DiscountModel;
import com.pvnshop.models.OrderDetailModel;
import com.pvnshop.models.OrderModel;
import com.pvnshop.models.ProductModel;
import com.pvnshop.models.UserModel;
import com.pvnshop.service.ICartService;
import com.pvnshop.service.IDiscountService;
import com.pvnshop.service.IOrderDetailService;
import com.pvnshop.service.IOrderService;
import com.pvnshop.service.IProductService;
import com.pvnshop.service.IUserService;
import com.pvnshop.service.impl.CartServiceImpl;
import com.pvnshop.service.impl.DiscountServiceImpl;
import com.pvnshop.service.impl.OrderDetailServiceImpl;
import com.pvnshop.service.impl.OrderServiceImpl;
import com.pvnshop.service.impl.ProductServiceImpl;
import com.pvnshop.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = {"/cart","/deleteCart","/thanhToan","/xacnhanthanhtoan","/capnhatdb"})
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static ICartService cartS = new CartServiceImpl();
	private static IProductService pS = new ProductServiceImpl();
	private static IUserService uS = new UserServiceImpl();
	private static IDiscountService disS = new DiscountServiceImpl();
	private static IOrderService oS = new OrderServiceImpl();
	private static IOrderDetailService odS = new OrderDetailServiceImpl();
	Locale vietnameseLocale = new Locale("vi", "VN");
    NumberFormat vietnameseCurrencyFormat = NumberFormat.getCurrencyInstance(vietnameseLocale);
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
		        o.add(cartModel.getQuantity());
				obs.add(o);
			}
			req.setAttribute("listp", obs);
			req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		}
		else if(url.contains("deleteCart")) {
			int id = Integer.parseInt(req.getParameter("id"));
			HttpSession session = req.getSession();
			//String user = (String) session.getAttribute("username");
			String user = "user01";
			cartS.delete(user,id);
			resp.sendRedirect(req.getContextPath()+"/cart");
		}
		else if(url.contains("capnhatdb")) {
			try {
				HttpSession session = req.getSession();
				List<Object> order = (List<Object>) session.getAttribute("order");
				OrderModel orderModel = new OrderModel();
				orderModel.setTime((Date)order.get(0));
				orderModel.setTotal((int)order.get(1));
				orderModel.setState((int)order.get(2));
				orderModel.setNote((String)order.get(3));
				orderModel.setPayment_method((String)order.get(4));
				orderModel.setUser_name((String)order.get(5));
				orderModel.setDiscount_id((Integer)order.get(6));
				orderModel.setShipping_method((String)order.get(7));
				orderModel.setShip_cost((int)order.get(8));
				oS.add(orderModel);
				int maxId = oS.maxID();
				List<CartModel> list = cartS.findByUser(orderModel.getUser_name());
				cartS.delete(orderModel.getUser_name());
				for (CartModel cartModel : list) {
					OrderDetailModel model = new OrderDetailModel(maxId,cartModel.getProductID(),cartModel.getQuantity());
					odS.add(model);
				}
				resp.sendRedirect(req.getContextPath()+"/home");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("thanhToan")) {	
			try {
				HttpSession session = req.getSession();
				//String user = (String) session.getAttribute("username");
				String user = "user01";
				List<CartModel> list = cartS.findByUser(user);
				for (CartModel cartModel : list) {
					int pId = cartModel.getProductID();
					String pId_str = pId + "";
					int quantity = Integer.parseInt(req.getParameter(pId_str));
					cartS.update(user, pId, quantity);}
				UserModel u = uS.getOneUser(user);
				List<Object> obj = new ArrayList<Object>();
				obj.add(u.getName());
				obj.add(u.getAddress());
				obj.add(u.getPhone());
				obj.add(u.getEmail());
				
				LocalDateTime ldt = LocalDateTime.now();
				long milliseconds = ldt.toInstant(ZoneOffset.UTC).toEpochMilli();
				Date date = new Date(milliseconds);
				List<DiscountModel> listDisc = disS.findEnabel(date);
				List<List<Object>> dateObj = new ArrayList<List<Object>>();
				LocalDate localDate = date.toLocalDate();
				for (DiscountModel model : listDisc) {
					List<Object> o = new ArrayList<Object>();
					Date date1 = model.getDateEnd();
					LocalDate localDate1 = date1.toLocalDate();
					long daysDifference = Math.abs(localDate.toEpochDay() - localDate1.toEpochDay());
					
					o.add(model.getDiscountID());
					o.add((model.getPercent()));
					o.add(vietnameseCurrencyFormat.format(model.getMaximum()));
					o.add(daysDifference);
					dateObj.add(o);
				}
				req.setAttribute("discount", dateObj);
				req.setAttribute("u", obj);
				req.getRequestDispatcher("/views/web/thanhtoan.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		else if(url.contains("xacnhanthanhtoan")) {
			HttpSession session = req.getSession();
			//String user = (String) session.getAttribute("username");
			String user = "user01";
			String shipMethod = req.getParameter("shipMethod");
			String paymentMethod = req.getParameter("paymentMethod");
			String note = req.getParameter("note");
			Integer discountID = null;
			LocalDateTime ldt = LocalDateTime.now();
			long milliseconds = ldt.toInstant(ZoneOffset.UTC).toEpochMilli();
			Date date = new Date(milliseconds);
			int shipCost = 0;
			if(paymentMethod.contains("express"))
				shipCost = 50000;
			else {
				shipCost = 30000;
			}
			int total = shipCost;
			List<CartModel> list = cartS.findByUser(user);
			List<List<Object>> obs = new ArrayList<List<Object>>();
			Locale vietnameseLocale = new Locale("vi", "VN");
	        NumberFormat vietnameseCurrencyFormat = NumberFormat.getCurrencyInstance(vietnameseLocale);
			for (CartModel cartModel : list) {
				int pID= cartModel.getProductID();
				ProductModel pmodel = pS.findByID(pID);
				List<Object> o = new ArrayList<Object>();
				o.add(pmodel.getProductName());
				o.add(cartModel.getQuantity());
				o.add(vietnameseCurrencyFormat.format(cartModel.getQuantity() * pmodel.getPrice()));
				total += cartModel.getQuantity() * pmodel.getPrice();
				obs.add(o);
			}
			float disCost = 0;
			if(req.getParameter("discount") != null && !req.getParameter("discount").contains("None"))
			{
				int disId = Integer.parseInt(req.getParameter("discount"));
				discountID = disId;
				DiscountModel discModel = disS.findById(disId);
				float percent = discModel.getPercent().floatValue();
				int maxDisc = discModel.getMaximum();
				disCost = total * percent;
				if(disCost > maxDisc)
					disCost = maxDisc;
				total -= disCost;
			}
			List<Object> order = new ArrayList<Object>();
			order.add(date);
			order.add(total);
			order.add(0);
			order.add(note);
			order.add(paymentMethod);
			order.add(user);
			order.add(discountID);
			order.add(shipMethod);
			order.add(shipCost);
			session.setAttribute("order", order);
	        req.setAttribute("shipCost", vietnameseCurrencyFormat.format(shipCost));
	        req.setAttribute("total", vietnameseCurrencyFormat.format(total));
	        req.setAttribute("discount", vietnameseCurrencyFormat.format(disCost));
	        req.setAttribute("plist", obs);
	        req.getRequestDispatcher("/views/web/xacnhanthanhtoan.jsp").forward(req, resp);
		}
		}
	}
	
