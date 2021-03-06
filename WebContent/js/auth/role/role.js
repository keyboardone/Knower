 $(document).ready(function () {
    	//获取源数据
        getData();  
        /** 导出 */ 
        $("#excelExport").jqxButton();
        $("#excelExport").click(function () {
        	var columns=[
	              { text: '角色名称', datafield: 'roleName', width: 195},
	              { text: '角色描述', datafield: 'roleDesc', width: 195}
             ];
			var textArray = "";
		 	var datafieldArray = "";
		 	for(var i=0;i<columns.length;i++){
		 		textArray+= columns[i].text+",";
		 		datafieldArray+= columns[i].datafield+",";
		 	}
		 	var ds = textArray+"-"+datafieldArray;
            window.location.href="../ubaseRoleMV/exportRole/?ds="+ds;        
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
	        	var ID=dataRecord.roleId;
	        	var row = {roleId:ID};
	        	$.ajax({
	         	url: "../ubaseRoleMV/deleteRole/",
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
      //关闭tooltip
        $('#popupWindowA').on('close', function (event) {
        	$("#rolename").jqxTooltip('close'); 
    		});
        
        /** 新增 */
	    $("#increase").jqxButton();           
	    $("#increase").click(function (){
	    	$("#rolename").val("");
	    	$("#roledesc").val("");
	    	$("#popupWindowA").jqxWindow({ position:'center' });
	    	$("#popupWindowA").jqxWindow('show'); 
	    });
	    $("#Cancel").jqxButton();
	  //新增时候检验没有通过关闭框，错误弹框立即关闭  zlc
	    $('#popupWindowA').on('close', function (event) {
	    	$("#rolename").jqxTooltip('close'); 
			});
	    $("#Save").jqxButton();
	    $("#popupWindowA").jqxWindow({ width: 300,height:220, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	    
	    $("#Save").click(function () {
	    	/*表单校验 前端校验*/
	    	//空格校验
	    	var item = $("#rolename").val(); 
	    	//非空校验
	        if(item==''){
			     $("#rolename").jqxTooltip({ content: "角色名称必须输入!", position: 'right', autoHide: false, trigger: "none", closeOnClick: true });
		    	 $("#rolename").jqxTooltip("open");
			     $('#rolename').focus;
			     return;
			   } 
		 //重名校验
	    	var rows=$("#jqxgrid").jqxGrid('getrows');
                   for(var i = 0; i < rows.length; i++){
	                    var row = rows[i];
				        if(item==row.roleName){
					        $("#rolename").jqxTooltip({ content: "角色名称不能重复!", position: 'right', autoHide: false, trigger: "none", closeOnClick: true });
					        $("#rolename").jqxTooltip("open");
					        return;
				        }  
                   }
		
	    	var row = {
                		   roleName:$("#rolename").val(),
                		   roleDesc:$("#roledesc").val()
                	};
	    	$.ajax({
	    		url: getRealPath() +"/ubaseRoleMV/increaseRole",
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
          var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
               editrow = rowindex;
          var offset = $("#jqxgrid").offset();
          var dataRecord = $("#jqxgrid").jqxGrid('getrowdata', editrow);
          		if(dataRecord==null){
	             	swal("请选择要修改的数据！");
	             	return;
	            }
          $("#RoleidU").val(dataRecord.roleId); 
          $("#rolenameU").val(dataRecord.roleName);
          $("#roledescU").val(dataRecord.roleDesc);
         
          // 弹出窗口
          $("#popupWindowU").jqxWindow({ position: 'center' });
          $("#popupWindowU").jqxWindow('show'); 
          
       });
       $("#popupWindowU").jqxWindow({ width: 300,height:200, resizable: false,  isModal: true, autoOpen: false, cancelButton: $("#CancelU"), modalOpacity: 0.01 });
       $("#CancelU").jqxButton();
       $("#SaveU").jqxButton();
       $("#SaveU").click(function () {
           var row = { 
        		   roleId: $("#RoleidU").val(), 
        		   roleName: $("#rolenameU").val(),
        		   roleDesc: $("#roledescU").val()
          
           };
       	$.ajax({
       		url: "../ubaseRoleMV/updateRole/",
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
                { name: 'roleId', type: 'String' },
                { name: 'roleName', type: 'String' },
                { name: 'roleDesc', type: 'String' },
            ],
            id: 'id',
            type:'POST',
            url: "../ubaseRoleMV/loadData/"
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
              { text: 'ID', datafield: 'roleId', width: 195 ,hidden:true },
              { text: '角色名称', datafield: 'roleName', width: 195},
              { text: '角色描述', datafield: 'roleDesc', width: 195},
             ]
            
        });
        
    };
   
    
    