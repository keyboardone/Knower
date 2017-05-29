<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript" 
    	src="<%=webapp%>/js/auth/user/user.js">
    </script>
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
            <div>新增用户信息</div>
            <div style="overflow: hidden;">
            	<form id="reportTemplateAddForm" >
                <table>
                    <tr>
                        <td align="right">用户英文名:</td>
                        <td align="left"><input id="userEname" /></td>
                    </tr>
                    <tr>
                        <td align="right">用户中文名:</td>
                        <td align="left"><input id="userCname" /></td>
                    </tr>
                    <tr>
                        <td align="right">密码:</td>
                        <td align="left"><input type="password" id="password"  /></td>
                    </tr>
                    <tr>
                        <td align="right">手机号:</td>
                        <td><input id="mobile" /></td>
                    </tr>
                    <tr>
                        <td align="right">住址:</td>
                        <td><input id="address" /></td>
                    </tr>
                    <tr>
                        <td align="right">电子邮箱:</td>
                        <td><input id="email" /></td>
                    </tr>
                    <tr>
                         <td align="right">是否有效:</td>
                        <td align="left"><div id="enabled" /></td>
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
            <div>修改用户信息</div>
            <div style="overflow: hidden;">
            	<form id="UserFormU">
            	 <input id="userIdU" hidden="hidden" style="overflow: hidden;"/>
                <table>
                    <tr>
                        <td align="right">用户英文名:</td>
                        <td align="left"><input id="userEnameU" /></td>
                    </tr>
                    <tr>
                        <td align="right">用户中文名:</td>
                        <td align="left"><input id="userCnameU" /></td>
                    </tr>
                    <tr>
                        <td align="right">密码:</td>
                        <td align="left"><input type="password" id="passwordU"  /></td>
                    </tr>
                    <tr>
                        <td align="right">手机号:</td>
                        <td><input id="mobileU" /></td>
                    </tr>
                    <tr>
                        <td align="right">住址:</td>
                        <td><input id="addressU" /></td>
                    </tr>
                    <tr>
                        <td align="right">电子邮箱:</td>
                        <td><input id="emailU" /></td>
                    </tr>
                    <tr>
                         <td align="right">是否有效:</td>
                        <td align="left"><div id="enabledU" /></td>
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
