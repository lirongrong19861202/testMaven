<%@ pagelanguage="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href=" <%=basePath%>"> 
<title>SCT-后台系统</title>
<script type="text/javascript" src="js/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/login/login.js"></script>
<link href="css/authority/login_css.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="login_center">
		<div id="login_area">
			<div id="login_box">
				<div id="login_form">
					<form id="submitForm" action="" method="post">
						<div id="login_tip">
							<span id="login_err" class="sty_txt2"></span>
						</div>
						<div>
							 用户名：<input type="text" name="userEntity.userCode" class="username" id="name">
						</div>
						<div>
							密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userEntity.password" class="pwd" id="pwd" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
						</div>
						<div id="btn_area">
							<input type="button" class="login_btn" id="login_sub"  value="登  录">
							<input type="reset" class="login_btn" id="login_ret" value="重 置">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>