package com.pvnshop.service.impl;
import java.util.List;

import com.pvnshop.dao.IProductDAO;
import com.pvnshop.dao.impl.ProductDAOImpl;
import com.pvnshop.models.ProductModel;
import com.pvnshop.service.IProductService;


public class ProductServiceImpl implements IProductService {
	
	private static IProductDAO pDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findTop3() {
		return pDAO.findTop3();
	}
	@Override
	public List<ProductModel> findRateTop3() {
		return pDAO.findRateTop3();
	}
	public ProductModel findByID(int id) 
	{
		return pDAO.findByID(id);
	}
	@Override
	public List<ProductModel> findAll() {
		return pDAO.findAll();
	}
	@Override
	public List<ProductModel> findTop() {
		// TODO Auto-generated method stub
		return pDAO.findTop();
	}
	@Override
	public List<ProductModel> findProductByCate(String cateId) {
		return pDAO.findProductByCate(cateId);
	}

	@Override
	public int CountProductByCate(int cateId) {
		return pDAO.CountProductByCate(cateId);
	}
	@Override
	public List<ProductModel> sortPriceLowtoHigh() {
		return pDAO.sortPriceLowtoHigh();
	}
	@Override
	public List<ProductModel> sortPriceHightoLow() {
		return pDAO.sortPriceHightoLow();
	}
	@Override
	public ProductModel getLastestProduct() {
		return pDAO.getLastestProduct();
	}
	@Override
	public void InsertProduct(ProductModel model) {
		pDAO.InsertProduct(model);
	}
	@Override
	public void DeleteProduct(int productID) {
		pDAO.DeleteProduct(productID);
	}
	@Override
	public void UpdateProduct(ProductModel model) {
		pDAO.UpdateProduct(model);
	}
	@Override
	public int CreateProductID() {
			List<ProductModel> Pro = pDAO.findAll();
			int proid = Pro.get(Pro.size()-1).getProductID();
			return proid + 1;
	}
}
