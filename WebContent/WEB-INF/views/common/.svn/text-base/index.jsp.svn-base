<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
	String path = request.getContextPath();
	String webapp = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
%>
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.base.css" type="text/css" />
<!-- theme -->
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.darkblue.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.energyblue.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.android.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.arctic.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.bootstrap.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.classic.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.fresh.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.glacier.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.highcontrast.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.metro.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.metrodark.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.office.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.orange.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.shinyblack.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.summer.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/styles/jqx.arctic.css" type="text/css" />
<link rel="stylesheet" href="<%=webapp%>/css/common.css" type="text/css" />
<script type="text/javascript" src="<%=webapp %>/js/common/common.js"></script>
   
<!-- end theme -->
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxmenu.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxcheckbox.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxnavbar.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxlistbox.js"></script>
<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    initMenu();
});

var showMenuobjs
function initMenu(){
	
	var ajax = getAjax();
	ajax.open("GET","menu",true);
	ajax.send(null);
	ajax.onreadystatechange = doResult;
	function doResult(){
		if (ajax.readyState == 4) {//4代表执行完成
            if (ajax.status == 200) {//200代表执行成功
                var menuStr = ajax.responseText;
                var menuObjs = eval(menuStr);
                showMenuobjs=menuObjs;
                var html = "";
                if(menuObjs.length>0){
                    for(var i=0;i<menuObjs.length;i++){
						html += makeMenuHtml(menuObjs[i]);
                    }
					document.getElementById("nav").innerHTML = html;
					renderToMenu();
                }
            }
        }
	}
}
function renderToMenu(){
	    $("#jqxMenu").jqxMenu({ width: '100%', height: '32px', 
	    			showTopLevelArrows: true,theme:'classic'});
	    $("#jqxMenu").css('visibility', 'visible');
        $("#jqxMenu").jqxMenu('focus');
        
}
function makeMenuHtml(data){
	//设置显示的下拉展示菜单的宽度
	var html = "";
	if(data.subMenuList!= null && data.subMenuList.length>0){
		html += "<li onclick=\"shownav('"+data.menuId+"')\"  style='width: 100px;'><a href='#'>"+data.menuName+"</a>"
		html += "<ul style='width: 115px;'>"
		for(var i=0;i<data.subMenuList.length;i++){
			html += makeSubHtml(data.subMenuList[i]);
		}
		html += "</ul>"
		html += "</li>"
	}else{
		html += "<li  onclick=\"shownav('"+data.menuId+"')\" style='width: 100px;'><a href='#'>"+data.menuName+"</a></li>"
	}
	return html;
}
	
function makeSubHtml(data){
		var html = "";
		if(data.subMenuList!= null && data.subMenuList.length>0){
			//设置显示的下拉展示菜单的宽度 115px
			html += "<li  onclick=\"shownav('"+data.menuId+"')\"><a href='" + data.url + "'  target='businessFrame' >"+data.menuName+"</a>"

			html += "<ul style='width: 180px'>"
			for(var i=0;i<data.subMenuList.length;i++){
				html += makeSubHtml(data.subMenuList[i]);
			}
			html += "</ul>"
			html += "</li>"
		}else{
			html += "<li  onclick=\"shownav('"+data.menuId+"')\"><a href='" + data.url + "' target='businessFrame'>"+data.menuName+"</a></li>";
		}
		return html;
}
function openWindow(uri){
	var iWidth=360;
	var iHeight=240;
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
	window.open(uri,'',"width=360px,height=240px,top="+iTop+",left="+iLeft+",scrollbars=no,location=no,toolbar=no");
}
	function udPwd() {
	debugger;
		dwrAsynService.isEditPwd(function (f) {
			if (!f) {
				alert("今天您已修改过密码，每天只能修改一次！");
				return;
			}
			var returnValue = openWindow("editPswd.action");
			if (!returnValue) {
			    returnValue = window.returnValue;
			}
		});
	}
function forceUdPwd() {
		dwrAsynService.isEditPwd(function (f) {
			if (!f) {
				alert("今天您已修改过密码，每天只能修改一次！");
				return;
			}
			results = window.showModalDialog("editPswd.action", function () {
				document.getElementById("pswl_v").style.display = "none";
			}, "dialogWidth:360px;dialogHeight:240px;scroll=0;help=0;status=0;");
			if(results != true){
				top.location.href = 'logout.ajax';
			} else {
				dwrAsynService.updatePasswordCallback(function (f) {});
			}
		});
}

function getAjax() {
	var s = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP", "MSXML.XMLHTTP", "MSXML3.XMLHTTP"];
	if (window.ActiveXObject) {
		for(var i=0; i<s.length; i++) {
			try{
				return new ActiveXObject(s[i]);
			}catch(e){ }
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else return null;
}
		
function SetCwinHeight() {
	var iframeid = document.getElementById("businessFrame"); 
	iframeid.height = document.body.offsetHeight/1.15;
} 
/**
 * 显示 导航条
 name 为 菜单名称
 id 为父菜单id
 */
	function shownav(id){
	
		$.ajax({
            type: "GET",
            url: getRealPath()+"/ubaseMenuMV/loadData",
            data: {"id":id},
            success: function(data){
            	document.getElementById("shownav").innerHTML=data.data;
                     }
        });
	}
	
	

</script>
<head>
</head>
<body style="background-color:white;margin: 0px; height: 620px; width: 100%;overflow-y: hidden;overflow-x: hidden "   >
	
	<div style="padding: 3px;">
	<!-- logo -->
	<div id='logo'   style="background-image: url(<%=webapp%>/images/head-bgimg.png) ;background-repeat: no-repeat;background-size:100%;height:80px;border-bottom-style:solid;border-bottom-width:1px;border-bottom-color:red" >
	<img style="padding: 20px" src="<%=webapp%>/images/index_logo.png"/>
	</div>
	
		<!-- 菜单 -->
		<div class="menu" style="float: left;">
			<div id='jqxMenu'>
				<ul id="nav" style="padding:0px"></ul>
	    	</div>
		</div>
		<!-- 按钮 -->
		<div id="head" style="float: right">
			<div >
				<ul>
					<li  id="username" style="float: left;display: inline;text-align: center;margin-right: 10px;">当前用户：<span><%=session.getAttribute("username")%></span></li>
					<li style="float: left;display: inline;text-align: center;margin-right: 10px;"><a href="logout.do" onclick="logout()" target="_top"><img src="<%=webapp %>/images/exit_DF.png" class="pic2" title="注销2" /></a></li>
					
					<!--  <li><a href="javascript:;" onclick="udPwd()"><img src="<%=webapp %>/images/unlock.png" class="pic2" title="修改密码" ></a></li>-->
				</ul>
			</div>
		</div>
		
		<div id="shownav" style="margin-top:60px;height:20px;width:100%;text-align:left;padding-left: 15px;padding-top: 5px;
		font-family: Verdana,Arial,sans-serif;
font-style: normal;
font-size: 13px;" ></div>
	<!-- FRAME 开始 -->	
    <div   >
    	<frameset  id="indexFrame" name="indexFrame"  cols="*" framespacing="1" frameborder="1" border="1">
			<iframe id="businessFrame" name="businessFrame" scrolling="AUTO" frameborder="0" width="100%" src="" onload="SetCwinHeight()"></iframe>
		</frameset>
	</div>
	<!-- FRAME 结束 -->
</body>
</html>
