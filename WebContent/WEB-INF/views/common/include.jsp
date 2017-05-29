<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
	String path = request.getContextPath();
	String webapp = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
	String msg="";
	if(session.getAttribute("errorMessage")!=null){
		msg = session.getAttribute("errorMessage").toString();
	}
%>
<!-- theme -->
	<link rel="stylesheet" href="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/styles/jqx.base.css" type="text/css" />
    <link rel="stylesheet" href="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/styles/jqx.darkblue.css" type="text/css" />
    <link rel="stylesheet" href="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/styles/jqx.energyblue.css" type="text/css" />    
    <link rel="stylesheet" href="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/styles/jqx.classic.css" type="text/css" />   
    <link rel="stylesheet" href="<%=webapp %>/css/common.css" type="text/css" />
    
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxtreegrid.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxcheckbox.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxlistbox.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxexpander.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/globalization/globalize.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/globalization/globalize.culture.zh.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/globalization/globalize.culture.zh-CN.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxcalendar.js"></script>
	<script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdatetimeinput.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxmenu.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.filter.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.columnsresize.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdata.export.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.export.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.sort.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.pager.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxnumberinput.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxwindow.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxcombobox.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxpanel.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxtree.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxvalidator.js"></script> 
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxtooltip.js"></script>
    <script type="text/javascript" src="<%=webapp %>/extend-tools/jqwidgets/jqwidgets/jqxfileupload.js"></script>
	<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxnavbar.js"></script>
	<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxdropdownbutton.js"></script>
	<script type="text/javascript" src="<%=webapp%>/extend-tools/jqwidgets/jqwidgets/jqxtextarea.js"></script>
    <script type="text/javascript" src="<%=webapp %>/js/common/common.js"></script>
    <!-- sweetalert -->
    <link rel="stylesheet" href="<%=webapp %>/extend-tools/sweetalert/sweetalert.css" type="text/css" />
    <script type="text/javascript" src="<%=webapp%>/extend-tools/sweetalert/sweetalert.min.js"></script>
    <!-- end -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    $(document).ready(function () {
    	showErrorMsg();
    });
    var showErrorMsg = function(){
    	var msg =	"<%=msg%>";
		if(msg!=null && msg !=""){
	    		var html = '<div>错误信息</div>';
	    		html=html+'<div style="overflow: hidden;"><table><tr><td><span id="msg"  >';
	    		html=html+msg;
		    	html=html+'</span></td></tr><tr><td style="padding-top: 10px;" align="right"><input id="Cancel" type="button" value="确定" /></td></tr></table></div>';
    			$("#msgPopupWindow").append(html);
				$("#msgPopupWindow").jqxWindow({ width: 300, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	
				$("#msgPopupWindow").jqxWindow('show');
		}
 		<% session.removeAttribute("errorMessage"); %>
    }
	</script>
</head>
	<div id="msgPopupWindow" ></div>
</html>
