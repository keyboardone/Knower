 $(document).ready(function () {
 		var menuCheckInfo;
    	//获取源数据
        getData();  
        /** 导出 */ 
        $("#excelExport").jqxButton();
        $("#excelExport").click(function () {
        	var columns=[
	              { text: '菜单ID', datafield: 'menuId', width: 195 ,hidden:false },
	              { text: '菜单名称', datafield: 'menuName', width: 195},
	              { text: 'url地址', datafield: 'url', width: 195},
	              { text: '父菜单ID', datafield: 'menuParentId', width: 195},
	              { text: '层级', datafield: 'lev', width: 195}
             ];
			var textArray = "";
		 	var datafieldArray = "";
		 	for(var i=0;i<columns.length;i++){
		 		textArray+= columns[i].text+",";
		 		datafieldArray+= columns[i].datafield+",";
		 	}
		 	var ds = textArray+"-"+datafieldArray;
            window.location.href=getRealPath() +"/ubaseMenuMV/exportMenu/?ds="+ds;        
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
			//删除校验 角色资源关系表中不能存在此菜单资源
			
			function(){
				var ID=dataRecord.menuId;
	        	var row = {menuId:ID};
	        	$.ajax({
		         	url: getRealPath() +"/ubaseMenuMV/deleteMenuCheck",
		         	type:'POST', 
					async: false,
					data: row,
					success:function(data,textStatus){
						menuCheckInfo=data;
					}
	         	});		
	         	if(menuCheckInfo==true){
	         		swal("该菜单正在被其他角色资源使用,请先删除对应的角色资源!");
	         		return;
	         	}else{
	         		$.ajax({
			         	url: getRealPath() +"/ubaseMenuMV/deleteMenu",
			         	type:'POST',                        
			        	async:false,
			        	data: row,
			         	dataType:"json"
		         	});
		            var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
		            $("#jqxgrid").jqxGrid('deleterow', rowid);//刷新
		            swal("删除成功!", "数据已删除!", "success");
	         	}		
			});
			/**			
			function(){
	        	var ID=dataRecord.menuId;
	        	var row = {menuId:ID};
	        	$.ajax({
		         	url: getRealPath() +"/ubaseMenuMV/deleteMenu",
		         	type:'POST',                        
		        	async:false,
		        	data: row,
		         	dataType:"json"
	         	});
	            var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
	            $("#jqxgrid").jqxGrid('deleterow', rowid);//刷新
	            swal("删除成功!", "数据已删除!", "success");
            });
            */
        });
      
       
        
        /** 新增 */
	    $("#increase").jqxButton();           
	    $("#increase").click(function ()  {
	    	$("#menuId").val("");
	    	$("#menuName").val("");
	    	$("#url").val("");
	    	$("#menuParentId").val("");
	    	$("#lev").val("");
	    	$("#popupWindowA").jqxWindow({ position:'center' });
	    	$("#popupWindowA").jqxWindow('show'); 
	    });
	    $("#Cancel").jqxButton();
	  	//新增时候检验没有通过关闭框，错误弹框立即关闭  zlc
	    $('#popupWindowA').on('close', function (event) {
	    	$("#menuId").jqxTooltip('close'); 
	    	$("#menuName").jqxTooltip('close'); 
	    	//$("#url").jqxTooltip('close');
	    	$("#menuParentId").jqxTooltip('close'); 
	    	$("#lev").jqxTooltip('close'); 
			});
	    $("#Save").jqxButton();
	    $("#popupWindowA").jqxWindow({ width: 400,height:220, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	    
	    $("#Save").click(function () {
	    
	    	//测试前端 菜单ID校验
	       	var filterName = $("#menuId").val();
	       	var menuName=$("#menuName").val();
	       	var url=$("#url").val();
	       	var menuParentId=$("#menuParentId").val();
	       	var lev = $("#lev").val();
	       	var theRow = $("#jqxgrid").jqxGrid('getrows');
	       	if(filterName == ""){
       			$("#menuId").jqxTooltip({ content: "菜单ID不能为空!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
          		$("#menuId").jqxTooltip("open");
          		return;
       		}
	       	for(var i = 0;i<theRow.length;i++){
	       		var j = theRow[i];
	       		if(filterName == j.menuId){
	       			$("#menuId").jqxTooltip({ content: "菜单ID:"+$("#menuId").val()+",已存在，请修改!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
	          		$("#menuId").jqxTooltip("open");
	          		return;
	       		}
	       	}
	       	if(menuName == ""){
       			$("#menuName").jqxTooltip({ content: "菜单名称不能为空!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
          		$("#menuName").jqxTooltip("open");
          		return;
       		}
       		/*
	       	if(url == ""){
       			$("#url").jqxTooltip({ content: "url不能为空!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
          		$("#url").jqxTooltip("open");
          		return;
       		}
       		*/
	       	if(menuParentId == ""){
       			$("#menuParentId").jqxTooltip({ content: "父菜单ID不能为空!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
          		$("#menuParentId").jqxTooltip("open");
          		return;
       		}
	       	if(lev == ""){
       			$("#lev").jqxTooltip({ content: "lev不能为空!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
          		$("#lev").jqxTooltip("open");
          		return;
       		}
	    	var row = {
    			menuId:$("#menuId").val(),
    			menuName:$("#menuName").val(),
    			url:$("#url").val(),
    			menuParentId:$("#menuParentId").val(),
    			lev:$("#lev").val()
	    	};
	    	$.ajax({
	    		url: getRealPath() +"/ubaseMenuMV/insertMenu",
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
        var menuId;
        $("#update").click(function (){
          var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
               editrow = rowindex;
          var offset = $("#jqxgrid").offset();
          var dataRecord = $("#jqxgrid").jqxGrid('getrowdata', editrow);
          		if(dataRecord==null){
	             	swal("请选择要修改的数据！");
	             	return;
	            }
          menuId = dataRecord.menuId;
          $("#menuNameU").val(dataRecord.menuName);
          $("#urlU").val(dataRecord.url);
          $("#menuParentIdU").val(dataRecord.menuParentId);
          $("#levU").val(dataRecord.lev); 
          $("#menuParentIdU").attr({'disabled': true });
          // 弹出窗口
          $("#popupWindowU").jqxWindow({ position: 'center' });
          $("#popupWindowU").jqxWindow('show'); 
          
       });
       $("#popupWindowU").jqxWindow({ width: 400,height:400, resizable: false,  isModal: true, autoOpen: false, cancelButton: $("#CancelU"), modalOpacity: 0.01 });
       $("#CancelU").jqxButton();
       $("#SaveU").jqxButton();
       $("#SaveU").click(function () {
           var rowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
           var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
           var row = {
           	   menuId:menuId,
    		   menuName:$("#menuNameU").val(),
    		   url:$("#urlU").val(),
    		   menuParentId:$("#menuParentIdU").val(),
    		   lev:$("#levU").val()
	       };
	       	$.ajax({
	       		url: getRealPath() +"/ubaseMenuMV/updateMenu",
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
                { name: 'menuId', type: 'String' },
                { name: 'menuName', type: 'String' },
                { name: 'url', type: 'String' },
                { name: 'menuParentId', type: 'String' },
                { name: 'lev', type: 'String' }
            ],
            id: 'id',
            type:'POST',
            url: getRealPath() +"/ubaseMenuMV/getAllMenuList"
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
              { text: '菜单ID', datafield: 'menuId', width: 195 ,hidden:false },
              { text: '菜单名称', datafield: 'menuName', width: 195},
              { text: 'url地址', datafield: 'url', width: 195},
              { text: '父菜单ID', datafield: 'menuParentId', width: 195},
              { text: '层级', datafield: 'lev', width: 195}
             ]
        });
    };
   