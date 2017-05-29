<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" 
    	src="<%=webapp%>/js/auth/resroleresource/resroleresource.js">
    </script>	 
</head>
<body class='default'>
<div style="height: 300px;padding-top: 10px">
		
		<div id="controller" style='width: 1025px;text-align: right;'>
           	<input type="button" value="导出Excel" id="excelExport" />
           	<input type="button" value="新    增" id="increase" />
           	<input type="button" value="删    除" id="delete" />
		</div>
 		<div id="jqxgrid"  style="display: none">
 		
 		</div>
		
   		<div id="rolejqxgrid"  style="float:left">
   		
   		</div>
   		
   		<div id="resourcejqxgrid" style="float:left; margin-left:25px">
   		
   		</div>
</div>
<div id="popupWindow">
            <div>新增角色资源信息</div>
            <div style="overflow: hidden;">
            <form>
                <table>
                    <tr>
                        <td align="right">角色名称:</td>
                        <td align="left">
                        	<input id="roleName" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right">资源名称:</td>
                        <td align="left">
                        	<div id="menuName">
                        		<div id="treeButton" />
                        			
                        		</div>
                        	</div>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="Save" value="保存" /><input id="Cancel" type="button" value="取消" /></td>
                    </tr>
                </table>
            </form>
            </div>
</div> 

</body>
</html>
