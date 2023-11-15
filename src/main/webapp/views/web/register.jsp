<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<style>
  /* Style for the registration form */
  .aa-myaccount-register {
    background: #f4f4f4;
    padding: 20px;
    border-radius: 5px;
    margin-top: 20px;
  }
h2 {
	font-size: 20px;
	color: #DC3545;
}
  .aa-myaccount-register h4 {
    color: #333;
    font-size: 24px;
    margin-bottom: 20px;
  }

  .aa-login-form label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
  }

  .aa-login-form input[type="text"],
  .aa-login-form input[type="password"],
  .aa-login-form input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  .aa-login-form button {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    text-align: center;
    text-decoration: none;
    outline: none;
    color: #fff;
    background-color: #28a745;
    border: none;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  .aa-login-form button:hover {
    background-color: #218838;
  }

  /* Additional styles for error messages */
  p[style^="color:red;"] {
    margin-top: 5px;
    margin-bottom: 15px;
    font-size: 14px;
  }
</style>

<c:url value = "/templates/login/assets" var="url"/>
<section id="aa-catg-head-banner">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h1>Đăng ký</h1>
        <ol class="breadcrumb">
          <li style="color:#fff">Đăng ký tài khoản</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-register">                 
                 <h4>Đăng ký</h4>
                 <h2>${error}</h2>
                 <form name="formRegister" class="aa-login-form" method="post" action="register" >
                    <label for="">Họ tên<span>*</span></label>
                    <input type="text" placeholder="Name" name="name" required>   
                     <label for="">Email <span>*</span></label>
                    <input type="text" placeholder="useremail@gmail.com" name="email" required>
                    <label for="">Số điện thoại<span>*</span></label>
                    <input type="text" placeholder="Số điện thoại" name="phone" required>
                    <label for="">Địa chỉ<span>*</span></label>
                    <input type="text" placeholder="Địa chỉ" name="address" required>      
                     <label for="">Username<span>*</span></label>
                    <input type="text" placeholder="Username" name="username" required>
                    <label for="">Mật khẩu<span>*</span></label>  
                    <input type="password" placeholder="Password" name="password" required>  
                    <input type="date" style="display: none" placeholder="Password" name="created" id="the-date">                                   
                    
                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
        			: request.getAttribute("errMessage")%></p>
			        <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
			        : request.getAttribute("Message")%></p>      
			         <button type="reset" class="aa-browse-btn" value="Reset">Đặt lại</button>  
                      <button type="submit" class="aa-browse-btn">Đăng ký</button>                         
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

<!--  end content-->
   <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>
  

