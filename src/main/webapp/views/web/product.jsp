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
							<li><a href="#">Home</a></li>
							<li><a href="#">All Categories</a></li>
							<li><a href="#">Accessories</a></li>
							<li class="active">Headphones (227,490 Results)</li>
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
							<h3 class="aside-title">Categories</h3>
							<div class="checkbox-filter">

								<div class="input-checkbox">
									<input type="checkbox" id="category-1">
									<label for="category-1">
										<span></span>
										Laptops
										<small>(120)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-2">
									<label for="category-2">
										<span></span>
										Smartphones
										<small>(740)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-3">
									<label for="category-3">
										<span></span>
										Cameras
										<small>(1450)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-4">
									<label for="category-4">
										<span></span>
										Accessories
										<small>(578)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-5">
									<label for="category-5">
										<span></span>
										Laptops
										<small>(120)</small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-6">
									<label for="category-6">
										<span></span>
										Smartphones
										<small>(740)</small>
									</label>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Price</h3>
							<div class="price-filter">
								<div id="price-slider"></div>
								<div class="input-number price-min">
									<input id="price-min" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
								<span>-</span>
								<div class="input-number price-max">
									<input id="price-max" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Brand</h3>
							<div class="checkbox-filter">
								<div class="input-checkbox">
									<input type="checkbox" id="brand-1">
									<label for="brand-1">
										<span></span>
										SAMSUNG
										<small>(578)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-2">
									<label for="brand-2">
										<span></span>
										LG
										<small>(125)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-3">
									<label for="brand-3">
										<span></span>
										SONY
										<small>(755)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-4">
									<label for="brand-4">
										<span></span>
										SAMSUNG
										<small>(578)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-5">
									<label for="brand-5">
										<span></span>
										LG
										<small>(125)</small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" id="brand-6">
									<label for="brand-6">
										<span></span>
										SONY
										<small>(755)</small>
									</label>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Top selling</h3>
							<div class="product-widget">
								<div class="product-img">
									<img src="${i.image}" alt="">
								</div>
								<div class="product-body">
									<c:forEach var="i" items="${top3}">
									<h3 class="product-name"><a href="#">${i.productName }</a></h3>
									<h4 class="product-price">${i.price}</h4>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->
					</div>
					<!-- /ASIDE -->

            <!-- STORE -->
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
                <!-- /store top filter -->

                <!-- store products -->
                <div class="row" id="product-list">
                    <div class="row">
					    <c:forEach var="i" items="${listProduct}">
					        <div class="col-md-4 col-xs-6 product-item">
					            <div class="product">
					                <div class="product-img">
					                    <img src="${i.image}" alt="Ảnh sản phẩm">
					                    <div class="product-label">
					                        <span class="sale">-30%</span>
					                        <span class="new">NEW</span>
					                    </div>
					                </div>
					                <div class="product-body">
					                    <p class="product-category">Category</p>
					                    <h3 class="product-name"><a href="product-detail?id=${i.productID}">${i.productName}</a></h3>
					                    <h4 class="product-price">${i.price}</h4>
					                    <div class="product-btns">
					                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
					                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
					                    </div>
					                </div>
					                <div class="add-to-cart">
					                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
					                </div>
					            </div>
					        </div>
					    </c:forEach>
					</div>
                </div>
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
            <!-- /STORE -->
        </div>
    </div>
</div>
<!-- /SECTION -->

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
