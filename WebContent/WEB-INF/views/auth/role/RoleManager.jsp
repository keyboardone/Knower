<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="../../common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript" src="<%=webapp %>/js/auth/role/role.js"></script>
</head>
    <body>
	    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;margin-top: 20px;">
		<div id="controller">
			<div style="width: 70%;float: left;">&nbsp;</div>
			<div style="width: 30%;float: left;text-align: right">
				<input type="button" value="导出Excel" id='excelExport' />
				<input type="button" value="新增" id='increase' />
				<input type="button" value="修改" id='update' />
				<input type="button" value="删除" id='delect' />
			</div>
		</div>
      	<div id="jqxgrid"></div>
     </div>  
       
       	  
       	  <div id="popupWindowA">
            <div>新增角色</div>
            <div style="overflow: hidden;">
            <form id="roleForm" >
                <table>
                    <tr>
                        <td align="right">角色名称:</td>
                        <td align="left"><input id="rolename" /></td>
                    </tr>
                    <tr>
                        <td align="right">角色描述:</td>
                        <td align="left"><input id="roledesc" /></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="Save" value="保存" /><input id="Cancel" type="button" value="取消" /></td>
                    </tr>
                </table>
              </form>
            </div>
          </div> 
          <div id="popupWindowU">
            <div>修改角色</div>
            <div style="overflow: hidden;">
            	<form id="roleFormU">
            	 <input id="RoleidU" hidden="hidden" style="overflow: hidden;"/>
                <table>
                    <tr>
                        <td align="right">角色名称:</td>
                        <td align="left"><input id="rolenameU" /></td>
                    </tr>
                    <tr>
                        <td align="right">角色描述:</td>
                        <td align="left"><input id="roledescU" /></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="SaveU" value="保存" /><input id="CancelU" type="button" value="取消" /></td>
                    </tr>
                </table>
                </form>
            </div>
       </div> 
    </body>
    </html>
