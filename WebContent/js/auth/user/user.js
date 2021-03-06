var lstdata;
$(document).ready(function () {
    	//获取源数据
        getData();  
        /** 导出 */ 
        $("#excelExport").jqxButton();
        $("#excelExport").click(function () {
        	var columns=[
	              { text: 'ID', datafield: 'userId', width: 195 ,hidden:false },
	              { text: '用户英文名', datafield: 'userEname', width: 195},
	              { text: '用户中文名', datafield: 'userCname', width: 195},
	              { text: '密码', datafield: 'password', width: 195},
	              { text: '手机号', datafield: 'mobile', width: 195},
	              { text: '住址', datafield: 'address', width: 195},
	              { text: '电子邮箱', datafield: 'email', width: 195},
	              { text: '是否有效', datafield: 'enabled', width: 195}
             ];
			var textArray = "";
		 	var datafieldArray = "";
		 	for(var i=0;i<columns.length;i++){
		 		textArray+= columns[i].text+",";
		 		datafieldArray+= columns[i].datafield+",";
		 	}
		 	var ds = textArray+"-"+datafieldArray;
            window.location.href=getRealPath() +"/UserController/exportUser/?ds="+ds;        
        });
        /** 删除 */      
        $("#delect").jqxButton();
        $("#delect").click(function ()  {
        	var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
			editrow = rowindex;
        	var dataRecord = $("#jqxgrid").jqxGrid('getrowdata', editrow); 
	             if(dataRecord==null){
	             	swal("请选择要删除的数据！");
	             	return;
	             }
        	swal({
				title: "",
				text: "确定要删除数据?",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: '#DD6B55',
				confirmButtonText: '是的, 删除!',
				cancelButtonText: '不, 再想想',
				closeOnConfirm: false
			},
			function(){
	        	var ID=dataRecord.userId;
	        	var row = {userId:ID};
	        	$.ajax({
	         	url: getRealPath() +"/UserController/deleteUser",
	         	type:'POST',                        
	        	async:false,
	        	data: row,
	         	dataType:"json"
	         	});
	            var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
	            $("#jqxgrid").jqxGrid('deleterow', rowid);//刷新
	            swal("删除成功!", "数据已删除!", "success");
            });
        });
      
       
        
        /** 新增 */
	    $("#increase").jqxButton();           
	    $("#increase").click(function ()  {
	    	$("#userEname").val("");
	    	$("#userCname").val("");
	    	$("#password").val("");
	    	$("#mobile").val("");
	    	$("#address").val("");
	    	$("#email").val("");
	    	$("#enabled").val("YES");
	    	$("#popupWindowA").jqxWindow({ position:'center' });
	    	$("#popupWindowA").jqxWindow('show'); 
	    });
	    $("#Cancel").jqxButton();
	  //新增时候检验没有通过关闭框，错误弹框立即关闭  zlc
	    $('#popupWindowA').on('close', function (event) {
	    	$("#userEname").jqxTooltip('close'); 
	    	$("#userCname").jqxTooltip('close'); 
	    	$("#password").jqxTooltip('close'); 
			});
	    $("#Save").jqxButton();
	    $("#popupWindowA").jqxWindow({ width: 300,height:420, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	    
	    $("#Save").click(function () {
	    	//测试前端 用户英文名校验
	       	var filterName = $("#userEname").val();
	       	var userCname = $("#userCname").val();
	       	var password = $("#password").val();
	       	var shuzi=/^[0-9]$/; 
	       	var zimu=/^[a-z]|[A-Z]$/;
	       	var tesu=/^[^A-Za-z0-9]$/;
	       	var flag=0;
	       	var s = password.split('');
	       	var theRow = $("#jqxgrid").jqxGrid('getrows');
	       	for(var i = 0;i<theRow.length;i++){
	       		var j = theRow[i];
	       		if(filterName == j.userEname){
	       			$("#userEname").jqxTooltip({ content: "用户英文名:"+$("#userEname").val()+",已存在，请修改!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
	          		$("#userEname").jqxTooltip("open");
	          		return;
	       		}
	       	}
		    //测试前端 用户英文名非空校验
		    if($("#userEname").val()==''){
		    	$("#userEname").jqxTooltip({ content: "用户英文名必须输入!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#userEname").jqxTooltip("open");
		        return;
		    }
		    //测试前端，用户英文名不能有中文   	
		    if((/[\u4e00-\u9fa5]+/).test($("#userEname").val())){
		    	$("#userEname").jqxTooltip({ content: "用户英文名不能有中文!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#userEname").jqxTooltip("open");
		        return;
		    }
		    //测试前端 用户名中不能有空格
		    var testChinese = $("#userEname").val().split("");
		    for(var i = 0;i<testChinese.length;i++){
		    	if(testChinese[i]==' '){
			    	$("#userEname").jqxTooltip({ content: "用户英文名中不能有空格!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
			        $("#userEname").jqxTooltip("open");
			        return;
		        }
		    }
		    if($("#userCname").val()==''){
		    	$("#userCname").jqxTooltip({ content: "用户中文名必须输入!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#userCname").jqxTooltip("open");
		        return;
		    }
		    //测试前端 密码非空校验
		    if($("#password").val()==''){
		    	$("#password").jqxTooltip({ content: "密码必须输入!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#password").jqxTooltip("open");
		        return;
		    }
		    
		    for(var i=0;i<s.length;i++){
		    	  if (shuzi.exec(s[i])) {
		    	     flag = flag+1;
		    	     break;
		    	  }
		    	}
		    	for(var i=0;i<s.length;i++){
		    	  if (zimu.exec(s[i])) {
		    	    flag = flag+1;
		    	     break;
		    	  }
		    	}
		    	for(var i=0;i<s.length;i++){
		    	  if (tesu.exec(s[i])) {
		    	     flag = flag+1;
		    	     break;
		    	  }
		    	}
		    	if (flag != 3) {
		    		$("#password").jqxTooltip({ content: "密码必须由数字,字母,特殊符号组成！", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
			        $("#password").jqxTooltip("open");
			        return;
		    		}
		    if(password.indexOf(" ")!=-1){
		    	$("#password").jqxTooltip({ content: "密码必须是数字，英文和符号!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#password").jqxTooltip("open");
		        return;
		    }
		    if($("#password").val().length<6){
		    	$("#password").jqxTooltip({ content: "密码必须输入大于等于6位!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
		        $("#password").jqxTooltip("open");
		        return;
		    }
	    	
	    	var row = {
	    			userEname:$("#userEname").val(),
	    			userCname:$("#userCname").val(),
	    			password:$("#password").val(),
	    			mobile:$("#mobile").val(),
	    			address:$("#address").val(),
	    			email:$("#email").val(),
	    			enabled:$("#enabled").val()};
	    	$.ajax({
	    		url: getRealPath() +"/UserController/insertUser",
	    		type:'POST',                        
	    		async:false,
	    		data: row,
	    		dataType:"json"
	     	});
	    	$("#popupWindowA").jqxWindow('hide');//关闭弹出页面
	    	$("#jqxgrid").jqxGrid('updatebounddata', 'cells');//刷新页面信息
	    	message("新增成功！");
	    });

    
        /** 修改 */     
        $("#update").jqxButton();
        $("#update").click(function ()  {
          var enabled = new Array();
   		  enabled = ['YES','NO'];
   		  $("#enabledU").jqxDropDownList({ source: enabled, displayMember: "codeValue",valueMember: "codeValue", width: '170', dropDownHeight: 100});
          var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
               editrow = rowindex;
          var offset = $("#jqxgrid").offset();
          var dataRecord = $("#jqxgrid").jqxGrid('getrowdata', editrow);
          if(dataRecord==null){
         		swal("请选择要修改的行!");
         		return;
         }
          $("#userIdU").val(dataRecord.userId); 
          $("#userEnameU").val(dataRecord.userEname);
          $("#userCnameU").val(dataRecord.userCname);
          $("#passwordU").val(dataRecord.password);
          $("#mobileU").val(dataRecord.mobile); 
          $("#addressU").val(dataRecord.address); 
          $("#emailU").val(dataRecord.email); 
          $("#enabledU").val(dataRecord.enabled);
          if($("#enabledU").val()=='NO'){
	        	$("#enabledU").val('NO');
	        }else{
	        	$("#enabledU").val('YES');
	        }
          // 弹出窗口
          $("#popupWindowU").jqxWindow({ position: 'center' });
          $("#userEnameU").attr({'disabled': true });
          $("#popupWindowU").jqxWindow('show'); 
          
       });
       $("#popupWindowU").jqxWindow({ width: 300,height:400, resizable: false,  isModal: true, autoOpen: false, cancelButton: $("#CancelU"), modalOpacity: 0.01 });
       $("#CancelU").jqxButton();
       //新增时候检验没有通过关闭框，错误弹框立即关闭  zlc
       $("#SaveU").jqxButton();
       $("#SaveU").click(function () {
           var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
           var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
           var row = {
           			userId:$("#userIdU").val(),
	    			userEname:$("#userEnameU").val(),
	    			userCname:$("#userCnameU").val(),
	    			password:$("#passwordU").val(),
	    			mobile:$("#mobileU").val(),
	    			address:$("#addressU").val(),
	    			email:$("#emailU").val(),
	    			enabled:$("#enabledU").val()};
       	$.ajax({
       		url: getRealPath() +"/UserController/updateUser",
       		type:'POST',                        
       		async:false,
       		data: row,
       		dataType:"json"
         	});
        	$("#popupWindowU").jqxWindow('hide');
           $("#jqxgrid").jqxGrid('updatebounddata', 'cells');
           message("修改成功！");
       });
    });
    var getData=function(){
        // 获取数据
        var source =
        {
            datatype: "json",
            datafields:  [
                { name: 'userId', type: 'String' },
                { name: 'userEname', type: 'String' },
                { name: 'userCname', type: 'String' },
                { name: 'password', type: 'String' },
                { name: 'mobile', type: 'String' },
                { name: 'address', type: 'String' },
                { name: 'email', type: 'String' },
                { name: 'enabled', type: 'String' }
                
            ],
            id: 'id',
            type:'POST',
            url: getRealPath() +"/UserController/loadUserData"
        };
        // 初始化数据列表
        var dataAdapter = new $.jqx.dataAdapter(source);
        $("#jqxgrid").jqxGrid(
        {             
            width: document.body.clientWidth,
            source: dataAdapter,           
            filterable: true,
            showfilterrow: true,
            pageable: true,
            autoheight: true,
            sortable: true,
            columnsresize: true,
            columns: [
              { text: 'ID', datafield: 'userId', width: 195 ,hidden:false },
              { text: '用户英文名', datafield: 'userEname', width: 195},
              { text: '用户中文名', datafield: 'userCname', width: 195},
              { text: '密码', datafield: 'password', width: 195},
              { text: '手机号', datafield: 'mobile', width: 195},
              { text: '住址', datafield: 'address', width: 195},
              { text: '电子邮箱', datafield: 'email', width: 195},
              { text: '是否有效', datafield: 'enabled', width: 195,
            	  cellsrenderer: function (row, columnfield, value, defaulthtml, columnproperties) {
                      if (value =='NO') {
                          return 'NO';
                      }
                      else {
                          return 'YES';
                      }
                  }     
              }
             ]
            
        });
        /** 下拉列表 */
        /** 加载下拉列表 */
 		var enabled = new Array();
   		enabled = ['YES','NO'];
   		$("#enabled").jqxDropDownList({ source: enabled, displayMember: "codeValue",valueMember: "codeValue", width: '170', dropDownHeight: 100});
    		
     	
    };
    
   