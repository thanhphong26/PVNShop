<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- Product main img -->
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<div class="product-preview">
								<img src="${detailPro.image }" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product03.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product06.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product08.png" alt="">
							</div>
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2  col-md-pull-5">
						<div id="product-imgs">
							<div class="product-preview">
								<img src="./img/product01.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product03.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product06.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product08.png" alt="">
							</div>
						</div>
					</div>
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${detailPro.productName}</h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
								<a class="review-link" href="#">${ allRate} Review(s) | Add your review</a>
							</div>
							<div>
								<fmt:formatNumber type="currency" value="${detailPro.price}" currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />
                                    <h4 class="product-price">${formattedPrice}</h4>
								<span class="product-available">  ${detailPro.inventory > 0 ? 'In Stock' : 'Out of Stock'}</span>
							</div>

							<div class="product-options">
								<label>
									Size
									<select class="input-select">
										<option value="0">${detailPro.size}</option>
									</select>
								</label>
								<label>
									Color
									<select class="input-select">
										<option value="0">${detailPro.color}</option>
									</select>
								</label>
							</div>

						 <div class="add-to-cart">
		                    <!-- Sửa nội dung của thẻ button và sự kiện onclick -->
		                    <button class="add-to-cart-btn" onclick="addToCart(${detailPro.productID})">
							    <i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
							</button>

		                </div>

							<ul class="product-links">
								<li>Category:</li>
								<li><a href="/PVNShop/product">${catePro.cateName}</a></li>
							</ul>

						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
								<li><a data-toggle="tab" href="#tab3">Reviews (${allRate })</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">
											<p>${detailPro.description}</p>
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab3  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										<!-- Rating -->
										<div class="col-md-3">
											<div id="rating">
												<div class="rating-avg">
													<span>${avgStar}</span>
													<div class="rating-stars">
														<c:forEach var="j" begin="1" end="${avgStar}" step="1">
																<i class="fa fa-star"></i>
															</c:forEach>
																<i class="fa fa-star-o empty"></i>
													</div>
												</div>
												<ul class="rating">
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
														</div>
														<div class="rating-progress">
															<div style="width: ${fiveStarP}%;"></div>
														</div>
														<span class="sum">${fiveStar}</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: ${fourStarP}%;"></div>
														</div>
														<span class="sum">${fourStar}</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: ${threeStarP}%;"></div>
														</div>
														<span class="sum">${threeStar}</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: ${twoStarP}%;"></div>
														</div>
														<span class="sum">${twoStar}</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: ${oneStarP}%;"></div>
														</div>
														<span class="sum">${oneStar}</span>
													</li>
												</ul>
											</div>
										</div>
										<!-- /Rating -->

										<!-- Reviews -->
										<div class="col-md-6">
											<div id="reviews">
												<ul class="reviews">
												<c:forEach var="i" items="${ratePro}">
													<li>
														<div class="review-heading">
															<h5 class="name">${i.username }</h5>
															
															<div class="review-rating">
															<c:forEach var="j" begin="1" end="${i.start}" step="1">
																<i class="fa fa-star"></i>
															</c:forEach>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>${i.context}</p>
														</div>
													</li>
													</c:forEach>
												</ul>
			
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">

										<div id="review-form">
										   <div id="review-form">
											    <form class="review-form" action="addReview" method="post">
											        <input class="input" type="text" placeholder="Your Name" name="username">
											        <textarea class="input" placeholder="Your Review" name="context"></textarea>
											       	<div class="input-rating">
														<span>Your Rating: </span>
														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div>
													</div>
											        <button class="primary-btn" type="submit">Submit</button>
											    </form>
											</div>
										</div>
										</div>
										<!-- /Review Form -->
									</div>
								</div>
								<!-- /tab3  -->
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Related Products</h3>
						</div>
					</div>

					<c:forEach var="i" items="${relatedProduct}">
					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="${i.image }" alt="">
								<div class="product-label">
									<span class="sale">-30%</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">${catePro.cateName}</p>
								<h3 class="product-name"><a href="detailProduct?id=${i.productID}">${i.productName}</a></h3>
								<fmt:formatNumber type="currency" value="${i.price - 100}" currencyCode="VND" pattern="#,##0 VND" var="formattedPrice" />
                                <h4 class="product-price">${formattedPrice}</h4>
								<div class="product-rating">
								</div>
							</div>
				            <div class="add-to-cart">
			                    <!-- Sửa nội dung của thẻ button và sự kiện onclick -->
			                    <button class="add-to-cart-btn" onclick="addToCart(${i.productID})">
								    <i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
								</button>

			                </div>
						</div>
					</div>
					<div class="clearfix visible-sm visible-xs"></div>
					
					<!-- /product -->
					</c:forEach>

					
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
<!-- /Section -->
			<script>
					    function addToCart(productID) {
					        // Thực hiện AJAX request để gọi Servlet
					        var xhr = new XMLHttpRequest();
					        xhr.open("POST", "add-to-cart", true);
					        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					        
					        // Gửi thông tin sản phẩm đến Servlet
					        var params = "id=" + productID;
					        xhr.send(params);
					        
					        // Xử lý phản hồi từ Servlet (nếu cần)
					        xhr.onreadystatechange = function () {
					            if (xhr.readyState === 4 && xhr.status === 200) {
					                // Xử lý phản hồi từ Servlet (nếu cần)
					                var response = xhr.responseText;
					                console.log(response);
					                alert("Thêm sản phẩm vào giỏ hàng thành công");
					                window.location.href = "cart";
					                // Cập nhật giao diện người dùng (nếu cần)
					            }
					        };
					    }
					</script>
</body>
</html>