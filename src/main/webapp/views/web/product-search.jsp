<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<ul class="breadcrumb-tree">
							<li><a href="home">Home</a></li>
							<li><a href="">Danh mục</a></li>
							<li><a href="#">Sản phẩm</a></li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
</div>
<!-- /BREADCRUMB -->
<!-- SECTION -->
	<div class="section">
	    <div class="container">
	        <div class="row">
	           <!-- ASIDE -->
						<div id="aside" class="col-md-3">
							<!-- aside Widget -->
							<div class="aside">
								<h3 class="aside-title">Danh mục sản phẩm</h3>
								<div class="checkbox-filter">
									<c:forEach var="c" items="${listCate}">
									<div class="input-checkbox">
										<label for="category-1" class="active">
											<a href="product?id=${c.cateID}" >${c.cateName}</a>
											<small></small>
										</label>
									</div>
									</c:forEach>
								</div>
							</div>
							<div class="aside">
								<h3 class="aside-title">Sản phẩm bán chạy</h3>
							 <c:forEach var="i" items="${bestSellerProduct}">
								<div class="product-widget">
									<div class="product-img">
										<img src="${i.image}" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="product-detail?id=${i.productID}">${i.productName}</a></h3>
										<h4 class="product-price">${i.price-100} <del class="product-old-price">${i.price}</del></h4>
									</div>
									</div>
									</c:forEach>
								</div>
							<!-- aside Widget -->
							<div class="aside">
								<h3 class="aside-title">Sản phẩm nổi bật</h3>
								<div class="checkbox-filter">
	
									<div class="card bg-light mb-3">
							            <div class="product">
							                <div class="product-img">
							                    <img src="${lastestProduct.image}" alt="Ảnh sản phẩm">
							                    <div class="product-label">
							                        <span class="new">NEW</span>
							                    </div>
							                </div>
							                <div class="product-body">
							                    <p class="product-category">Category</p>
							                    <h3 class="product-name"><a href="product-detail?id=${lastestProduct.productID}">${lastestProduct.productName}</a></h3>
												<h4 class="product-price">${i.price-1000000} <del class="product-old-price">${i.price}</del></h4>
							                	<h5 class="product-size">Khối lượng: ${lastestProduct.size} kg</h5>
							                </div>
							                <div class="add-to-cart">
							                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
							                </div>
							            </div>
							        </div>
								</div>
							</div>
		        </div>
		        <div id="store" class="col-md-9">
                <!-- store top filter -->
		                <div class="store-filter clearfix">
		                    <div class="store-sort">
		                        <label>
		                            Sort By:
		                            <select class="input-select" id="sort">
		                            	<option hidden></option>
		                                <option value="0">Giá từ thấp đến cao</option>
		                                <option value="1">Giá từ cao đến thấp</option>
		                            </select>
		                        </label>
		                    </div>
		              </div>
		            </div>
					<!-- STORE -->
					<h5>Các sản phẩm liên quan đến từ khóa </h5>
					<div id="store" class="col-md-9">
						
						<!-- store products -->					
						<div class="row">
						    <c:forEach var="i" items="${listSearch}">
						        <div class="col-md-4 col-xs-6">
						            <div class="product">
						                <div class="product-img">
						                    <img src="${i.image}" alt="Ảnh sản phẩm">
						                    <div class="product-label">
						                        <span class="new">NEW</span>
						                    </div>
						                </div>
						                <div class="product-body">
						                    <p class="product-category">Category</p>
						                    <h3 class="product-name"><a href="product-detail?id=${i.productID}">${i.productName}</a></h3>
						                    <h4 class="product-price">${i.price-100} VND</h4>
									    	<h5 class="product-size">Khối lượng: ${i.size} kg</h5>
						                </div>
						                <div class="add-to-cart">
						                    <!-- Sửa nội dung của thẻ button và sự kiện onclick -->
						                    <button class="add-to-cart-btn" onclick="addToCart(${i.productID})">
											    <i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
											</button>

						                </div>
						            </div>
						        </div>
						    </c:forEach>
						    <div class="clearfix visible-sm visible-xs"></div> <!-- /product -->
						</div>
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
						<!-- /store products -->
						<!-- store bottom filter -->
						<div class="store-filter clearfix">
							<span class="store-qty">Showing 20-100 products</span>
							<ul class="store-pagination">
								<li class="active">1</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
							</ul>
						</div>
						<!-- /store bottom filter -->
					</div>
		<script>
			    document.getElementById('sort').addEventListener('change', function() {
			        var selectedValue = this.value;
			        var products = document.querySelectorAll('.product-item');
			        var sortedProducts = Array.from(products);
			
			        sortedProducts.sort(function(a, b) {
			            var priceA = parseFloat(a.querySelector('.product-price').innerText.replace(/\D/g,'')); // Lấy giá và loại bỏ ký tự không phải số
			            var priceB = parseFloat(b.querySelector('.product-price').innerText.replace(/\D/g,'')); // Lấy giá và loại bỏ ký tự không phải số
			
			            if (selectedValue === '1') { // Nếu lựa chọn là giá cao đến thấp
			                return priceB - priceA;
			            } else { // Mặc định, sắp xếp từ thấp đến cao
			                return priceA - priceB;
			            }
			        });
			
			        var container = document.getElementById('product-list');
			        container.innerHTML = ''; // Xóa danh sách hiện tại
			
			        sortedProducts.forEach(function(product) {
			            container.appendChild(product); // Thêm sản phẩm đã sắp xếp vào container
			        });
			    });
		</script>
    </div>

</div>
<!-- /SECTION -->
