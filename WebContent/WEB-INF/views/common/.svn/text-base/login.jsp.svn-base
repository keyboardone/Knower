<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<%
 Object aa=request.getAttribute("error");
System.out.println("error:"+aa);
%>
<head>
<link href="<%=webapp %>/css/login-style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=webapp %>/js/common//login.js"></script>
</head>
<body class="login"  onkeydown="keyLogin();">
<form action="./login.do" method="post">
<div class="login_m">
	<div class="login_logo"><img src="<%=webapp %>/images/logo.png" width="260" height="60"/></div>
	<div class="login_boder">
		<div class="login_padding">
			<h2>用户名</h2>
			<label>
				<input type="text" id="username" name="userId" class="txt_input txt_input2" onfocus="if (value ==&#39;用户名&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;用户名&#39;}" value=""/>
			</label>
			<h2>密码</h2>
			<label>
				<input type="password" name="password" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value=""/>
			</label>
<!-- 			<p class="forgot"><a href="javascript:void(0);">忘记密码?</a></p> -->
			<div class="rem_sub">
				<div class="rem_sub_l">
<!-- 					<input type="checkbox" name="checkbox" id="save_me"/> -->
<!-- 					<label for="checkbox">记住</label> -->
				</div>
				<label>
					<input type="button" class="sub_button" name="button" id="button" onclick="dologin()"  value="登录" style="opacity: 0.7;"/>
				</label>
			</div>
		</div>
	</div><!--login_boder end-->
</div><!--login_m end-->

<br />
<br />


</form>
<!--  
<%
session.setAttribute("error","1");
String a = session.getAttribute("error").toString();
if(a!=""){
 %>
 alert(a);
 <% 
}
%>
-->

</body>
</html>