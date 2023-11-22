<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<style type="text/css">
.column {
	flex: 1;
}
</style>
</head>
<body>
	<hr>
	<div class="container bootstrap snippet">

		<div class="row">
			<div class="col-sm-3">
				<!--left col-->


				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar img-circle img-thumbnail" alt="avatar">
					<h1>${user.name}</h1>
				</div>
				<br>



				<ul class="list-group">
					<li class="list-group-item text-muted">Hoạt động <i
						class="fa fa-dashboard fa-1x"></i></li>
					<li class="list-group-item text-right"><span class="pull-left"><strong>Số
								đơn hàng đã đặt</strong></span></li>

				</ul>

				<div class="panel panel-default">
					<div class="panel-heading">Social Media</div>
					<div class="panel-body">

						<i class="fab fa-facebook"></i> <i class="fab fa-github"></i> <i
							class="fab fa-twitter"></i> <i class="fab fa-pinterest"></i> <i
							class="fab fa-google-plus"></i>
					</div>
				</div>
			</div>
			<!--/col-3-->
			<div class="col-sm-9">
				<div class="tab-content">
					<div class="tab-pane active" id="home">
						<hr>
						<form class="form" action="Account" method="post"
							id="registrationForm">
							<div class="form-group">

								<div class="col-xs-6">
									<label for="first_name"><h4>User Name</h4></label> <input
										type="text" class="form-control" name="username"
										id="first_name" placeholder="User name"
										value="${user.username}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">

								<div class="col-xs-6">
									<label for="last_name"><h4>Your name</h4></label> <input
										type="text" class="form-control" name="name" id="last_name"
										placeholder="name" title="enter your last name if any."
										value="${user.name}">
								</div>
							</div>
							<div class="form-group">

								<div class="col-xs-6">
									<label for="phone"><h4>Phone</h4></label> <input type="text"
										class="form-control" name="phone" id="phone"
										placeholder="enter phone"
										title="enter your phone number if any." value="${user.phone}">
								</div>
							</div>

							<div class="form-group">

								<div class="col-xs-6">
									<label for="email"><h4>Email</h4></label> <input type="email"
										class="form-control" name="email" id="email"
										placeholder="you@email.com" title="enter your email."
										value="${user.email}"> <input name="isAdmin"
										value="${user.isAdmin}" type="hidden"> <input
										name="password" value="${user.password}" type="hidden">
								</div>
							</div>
							<div class="form-group">

								<div class="col-xs-6">
									<label for="email"><h4>Address</h4></label> <input type="text"
										class="form-control" id="address" name="address"
										placeholder="somewhere" title="enter a location"
										value="${user.address}">
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<br>
									<button class="btn btn-lg btn-success" type="submit">
										<i class="fas fa-check-circle" style="color: #ffffff;"></i>
										Save
									</button>
									<br> <br>
								</div>
							</div>
						</form>

						<hr>

					</div>
					<!--/tab-pane-->

					<table border="1"
						style="margin-bottom: 50px; width: 100%; border-collapse: collapse; margin-top: 20px;">
						<thead style="background-color: #f2f2f2;">
							<th style="padding: 10px; text-align: left;">OrderID</th>
							<th style="padding: 10px; text-align: left;">Time</th>
							<th style="padding: 10px; text-align: left;">Total</th>
							<th style="padding: 10px; text-align: left;">Payment Method</th>
							<th style="padding: 10px; text-align: left;">Shipping Method</th>
							<th style="padding: 10px; text-align: left;">Ship Cost</th>
							<th style="padding: 10px; text-align: left;">Product name</th>
							<th style="padding: 10px; text-align: left;">Image</th>

						</thead>
						<tbody>
							<c:forEach var="orderDetail" items="${detail}">
								<tr style="border-bottom: 1px solid #ddd;">
									<td>${orderDetail.orderID}</td>
									<td>${orderDetail.time}</td>
									<td>${orderDetail.total}</td>
									<td>${orderDetail.payment_method}</td>
									<td>${orderDetail.order.shipping_method}</td>
									<td>${orderDetail.order.ship_cost}</td>
									<td>${orderDetail.product.productName}</td>
									<td><img src="${orderDetail.product.image}"
										alt="Product Image"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>



				</div>
				<!--/tab-pane-->
			</div>
			<!--/tab-content-->

		</div>
		<!--/col-9-->
	</div>
	<!--/row-->
</body>
</html>