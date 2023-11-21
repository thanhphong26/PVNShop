<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<br> <br>
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Thêm sản phẩm</h3>
						</div>
						<div class="card-body">
							<form action="SuaSanPham" method="post">
								<div class="row">
								<input name = "productID" value="${Product.productID}" type="hidden">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<label>Name</label> <input class="form-control" type="text"
												name="productName" value="${Product.productName}" />
										</div>
										<div class="form-floating mb-3">
											<label>Version</label> <input class="form-control"
												type="text" name="version" value="${Product.version}" />
										</div>
										<div class="form-floating mb-3">
											<label>Description</label>
											<!--<input class="form-control"
												type="text" name="description" /> -->
											<textarea rows="3" cols="45" name="description">${Product.description}</textarea>
										</div>
										<div class="form-floating mb-3">
											<label>Price</label><input class="form-control" type="text"
												name="price" value="${Product.price}" />
										</div>
										<div class="form-floating mb-3">
											<label>Color</label><input class="form-control" type="text"
												name="color" value="${Product.color}" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<label>Size</label><input class="form-control" type="text"
												name="size" value="${Product.size}" />
										</div>
										<div class="form-floating mb-3">
											<label>Inventory</label><input class="form-control"
												type="text" name="inventory" value="${Product.inventory}" />
										</div>
										<div class="form-floating mb-3">
											<label>Link image</label><input class="form-control"
												type="text" name="image" value="${Product.image}" />
										</div>
										<div class="form-floating mb-3">
											<label>Category</label><select name="category"
												class="form-control">
												<option value="" style="text-align: center">--
													Select --</option>
												<c:forEach var="category" items="${listCategory}">
													<option value="${category.cateID}"
														style="text-align: center"
														<c:if test="${category.cateID eq Product.cateID}">selected</c:if>>${category.cateName}</option>
												</c:forEach>
											</select>
										</div>

										<div class="form-floating mb-3">
											<label>Manufacturer</label><select name="manufacturer"
												class="form-control">
												<option value="" style="text-align: center">--
													Select --</option>
												<c:forEach var="manufacturer" items="${listManufacturer}">
													<option value="${manufacturer.manuID}"
														style="text-align: center"
														<c:if test="${manufacturer.manuID eq Product.manuID}">selected</c:if>>${manufacturer.manuName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<br>
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-primary" value="Cập nhật" />
								</div>
							</form>
						</div>
						<br> <br>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>