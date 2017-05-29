var theRoleId;
var theRoleName;
var theMenuId;
var theMenuName;
$(document).ready(function () {
    	//获取源数据
        getData();  
        getRoleData();
        
        /** 导出 */ 
        $("#excelExport").jqxButton();
        $("#excelExport").click(function () {
            $("#jqxgrid").jqxGrid('exportdata', 'xls', '用户资源信息导出');           
        });
        /** 删除 */      
        $("#delete").jqxButton();
        $("#delete").click(function ()  {
        	var rowindex = $("#resourcejqxgrid").jqxGrid('getselectedrowindex');
			editrow = rowindex;
        	var dataRecord = $("#resourcejqxgrid").jqxGrid('getrowdata', editrow); 
	             if(dataRecord==null){
	             	swal("请选择要删除的资源!");
	             	return;
	             }
        	swal({
				title: "",
				text: "确定要删除资源?",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: '#DD6B55',
				confirmButtonText: '是的, 删除!',
				cancelButtonText: '不, 再想想',
				closeOnConfirm: false
			},
			function(){
	        	var ID=dataRecord.roleMenuId;
	        	var row = {roleMenuId:ID};
	        	var checkMenuId=dataRecord.menuId;
	        	//前端校验 角色资源删除 在未删除子资源的情况下，不能直接删除父资源
	        	var rows=$("#resourcejqxgrid").jqxGrid('getrows');
	            for(var i = 0; i < rows.length; i++){
	            	var rowCheck = rows[i];
	            	if(rowCheck.menuId.length>4){
	            		//截取除去后五位的menuId字符串
	            		var deleteCheckInfo = rowCheck.menuId.substring(0,rowCheck.menuId.length-5);
	            		if(checkMenuId==deleteCheckInfo){
							swal("在未删除子资源的情况下，不能直接删除父资源!");	 
							return;           			
	            		}
	            	}
	            }
	        	$.ajax({
		         	url: getRealPath() +"/ResRoleResourceController/deleteResRoleResource",
		         	type:'POST',                        
		        	async:false,
		        	data: row,
		         	dataType:"json"
	         	});
	            var rowid = $("#resourcejqxgrid").jqxGrid('getrowid', rowindex);
	            $("#resourcejqxgrid").jqxGrid('deleterow', rowid); //刷新单行
	            getData();//维护全局变量lstdata
	            swal("删除成功!", "数据已删除!", "success");
            });
        });
      
        /** 新增 */
	    $("#increase").jqxButton();           
	    $("#increase").click(function ()  {
	    	//新增时获取当前角色名称
	    	$("#roleName").val(theRoleName);
	    	//新增时清空资源树
	    	var dropDownContent = null;
            $("#menuName").jqxDropDownButton('setContent', dropDownContent);
	    	$("#popupWindow").jqxWindow({ position:'center' });
	    	$("#roleName").attr({'disabled': true });//角色名称直接取，不再下拉列表选择了
	    	$("#popupWindow").jqxWindow('show'); 
	    });
	    $("#Cancel").jqxButton();
	    //关闭窗口时候校验和下拉树立即关闭      zlc
	    $('#popupWindow').on('close', function (event) {
	    	$("#roleName").jqxTooltip('close'); 
	    	$("#menuName").jqxTooltip('close'); 
	    	$("#menuName").jqxDropDownButton('close'); 
			});
	    $("#Save").jqxButton();
	    $("#popupWindow").jqxWindow({ width: 300,height:220, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	    
	    $("#Save").click(function () {
	    	/*前端校验*/
	    	//角色非空校验
	    	var roleName = theRoleName;
	    	if(roleName==null){
			     $("#roleName").jqxTooltip({ content: "角色名称，必须输入!", position: 'right', autoHide: false, trigger: "none", closeOnClick: true });
		    	 $("#roleName").jqxTooltip("open");
			     $("#roleName").focus;
			     return;
			} 
            //资源非空校验
            var menuName = theMenuName;
	        if(menuName==null){
			     $("#menuName").jqxTooltip({ content: "资源名称，必须输入!", position: 'right', autoHide: false, trigger: "none", closeOnClick: true });
		    	 $("#menuName").jqxTooltip("open");
			     $('#menuName').focus;
			     return;
			} 
		 	//资源重名校验
		    var rows=$("#resourcejqxgrid").jqxGrid('getrows');
            for(var i = 0; i < rows.length; i++){
            	var row = rows[i];
			    if(menuName==row.menuName){
			      $("#menuName").jqxTooltip({ content: "资源名称，不能有重复!", position: 'right', autoHide: false, trigger: "none", closeOnClick: true });
			      $("#menuName").jqxTooltip("open");
			      return;
			    }  
            }
            /**资源添加次序校验：必须先添加父菜单，才能添加子菜单
            	获取resourcejqxgrid表格资源对象 getMenuTree
            	先通过theMenuId获取当前资源对象 
            	再通过当前资源对象的menuParentId,获取父菜单对象
            	判断resourcejqxgrid表格中是否有资源对象
            		是: 只允许添加一级菜单
		               否: 判断表格资源对象中是否包含父菜单对象
	            		是:直接添加
						否:判断此菜单是否为一级菜单
							是:直接添加
							否:拦截，提示用户必须先添加父菜单          	
            */
            var getMenuTree = getMenuByMenuId();
            var fatherMenuId;
            var rows=$("#resourcejqxgrid").jqxGrid('getrows');
            if(rows.length=='0'){
            	for(var i=0;i<getMenuTree.length;i++){
	            	if(theMenuId==getMenuTree[i].menuId){
	            		fatherMenuId = getMenuTree[i].menuParentId;
	            	}
	            }
            	if(fatherMenuId=='-1'){
            		var roleId = theRoleId;
			    	var menuId = theMenuId;
			    	var row = {
			    			roleId:roleId,
			    			menuId:menuId
			    	};
			    	$.ajax({
			    		url: getRealPath() +"/ResRoleResourceController/insertResRoleResource",
			    		type:'POST',                        
			    		async:false,
			    		data: row,
			    		dataType:"json"
			     	});
			    	$("#popupWindow").jqxWindow('hide');//关闭弹出页面
			    	$("#jqxgrid").jqxGrid('updatebounddata', 'cells');//刷新页面信息
			    	getData();//维护全局变量lstdata
			    	getMenuData(theRoleId);
			    	theMenuName = null;
			    	message("新增成功！");
			    	return;
            	}else{
            		swal("必须先添加一级菜单!");
					return;
            	}
            }else{
            	for(var i=0;i<getMenuTree.length;i++){
	            	if(theMenuId==getMenuTree[i].menuId){
	            		fatherMenuId = getMenuTree[i].menuParentId;
	            	}
	            }
           		for(var i = 0; i < rows.length; i++){
	            	var row = rows[i];
				    if(fatherMenuId==row.menuId || fatherMenuId=='-1'){
				    	var roleId = theRoleId;
				    	var menuId = theMenuId;
				    	var row = {
				    			roleId:roleId,
				    			menuId:menuId
				    	};
				    	$.ajax({
				    		url: getRealPath() +"/ResRoleResourceController/insertResRoleResource",
				    		type:'POST',                        
				    		async:false,
				    		data: row,
				    		dataType:"json"
				     	});
				    	$("#popupWindow").jqxWindow('hide');//关闭弹出页面
				    	$("#jqxgrid").jqxGrid('updatebounddata', 'cells');//刷新页面信息
				    	getData();//维护全局变量lstdata
				    	getMenuData(theRoleId);
				    	theMenuName = null;
				    	message("新增成功！");
				    	return;
				    }
	            }
	            swal("必须先添加此菜单的父菜单!");
	            return;
            }
		   
		   
	    	//任冰 关键！ 下拉列表取值并保存 由全局变量获取
	    	var roleId = theRoleId;
	    	var menuId = theMenuId;
	    	var row = {
	    			roleId:roleId,
	    			menuId:menuId
	    	};
	    	$.ajax({
	    		url: getRealPath() +"/ResRoleResourceController/insertResRoleResource",
	    		type:'POST',                        
	    		async:false,
	    		data: row,
	    		dataType:"json"
	     	});
	    	$("#popupWindow").jqxWindow('hide');//关闭弹出页面
	    	$("#jqxgrid").jqxGrid('updatebounddata', 'cells');//刷新页面信息
	    	getData();//维护全局变量lstdata
	    	getMenuData(theRoleId);
	    	theMenuName = null;
	    	message("新增成功！");
	    });
    });
    
    /**加载所有数据*/
    var getData=function(){
    	$.ajax({
			url: getRealPath() +"/ResRoleResourceController/loadResRoleResourceData",
			type:'POST', 
			datatype: "json",
			async: false,
			success:function(data,textStatus){
				lstdata=data;
			}
		});
		// 获取角色资源的所有数据
		var source =
		{
			dataType: "json",
			datafields:  [
                { name: 'roleMenuId', type: 'String' },
                { name: 'roleId', type: 'String' },
                { name: 'menuId', type: 'String' },
                { name: 'roleName', type: 'String' },
                { name: 'menuName', type: 'String' }
            ],
           	id: 'id',
           	localdata: lstdata
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
              { text: '角色资源ID', datafield: 'roleMenuId', width: 195 ,hidden:true },
              { text: '角色ID', datafield: 'roleId', width: 195 ,hidden:true },
              { text: '资源ID', datafield: 'menuId', width: 195 ,hidden:true },
              { text: '角色名称', datafield: 'roleName', width: 195},
              { text: '资源名称', datafield: 'menuName', width: 195}
             ]
        });
		//获取下拉资源树
		var getMenuTree = getMenuByMenuId();
        var source =
		{
			dataType: "json",
			datafields:  [
                { name: 'menuId', type: 'String' },
                { name: 'menuName', type: 'String' },
                { name: 'menuParentId', type: 'String' }
            ],
           	id: 'id',
           	localdata: getMenuTree
        };
        var dataAdapter = new $.jqx.dataAdapter(source);
        dataAdapter.dataBind();
	    var menuTree = dataAdapter.getRecordsHierarchy(
        	'menuId', 'menuParentId', 'items', 
        	[{ name: 'menuName', map: 'label'},
        	{ name: 'menuId', map: 'value'}]
       	);
       	
		$("#menuName").jqxDropDownButton({ width: 170, height: 25});
		$("#treeButton").jqxTree({ source: menuTree, width: 200,height:200});
        $('#treeButton').on('select', function (event) {
           var args = event.args;
           var item = $('#treeButton').jqxTree('getItem', args.element);
           theMenuId = item.value;
           theMenuName = item.label;
           var dropDownContent = '<div style="position: relative; margin-left: 3px; margin-top: 5px;">' + item.label + '</div>';
           $("#menuName").jqxDropDownButton('setContent', dropDownContent);
        });
    };
    
    /**加载角色数据*/
    var getRoleData=function(){
        //获取角色信息
        var lstroledata;
    	lstroledata = getRoleByRoleId();
		var source =
		{
			dataType: "json",
			datafields:  [
                { name: 'roleId', type: 'String' },
                { name: 'roleName', type: 'String' }
            ],
           	id: 'id',
           	localdata: lstroledata
        };
    		
        // 初始化数据列表
        var dataAdapter = new $.jqx.dataAdapter(source);
        $("#rolejqxgrid").jqxGrid(
        {             
            //width: document.body.clientWidth,
            source: dataAdapter,           
            filterable: true,
            width:500,
            showfilterrow: true,
            pageable: true,
            //autoheight: true,
            sortable: true,
            columnsresize: true,
            columns: [
              { text: '角色名称', datafield: 'roleName'},
              { text: '角色ID', datafield: 'roleId'}
             ]
        });
        //联动
        $("#rolejqxgrid").click(function ()  {
        	var rowindex = $("#rolejqxgrid").jqxGrid('getselectedrowindex');
            editrow = rowindex;
	        var offset = $("#rolejqxgrid").offset();
	        var dataRecord = $("#rolejqxgrid").jqxGrid('getrowdata', editrow);
	        theRoleId = dataRecord.roleId;
	        theRoleName = dataRecord.roleName;
	        getMenuData(theRoleId);
        });
    };
    
    /**加载资源数据*/
    var getMenuData=function(theRoleId){
        //获取资源信息
        var themenudata = new Array();
        var j=0;
        lstmenudata = getMenuByMenuId();
    	//循环遍历角色资源对象，取出对应的资源名称
    	for(var i=0;i<lstdata.length;i++){
    		if(theRoleId==lstdata[i].roleId){
    			lstmenudata[i].menuName = lstdata[i].menuName;
    			lstmenudata[i].roleMenuId = lstdata[i].roleMenuId;
    			lstmenudata[i].menuId = lstdata[i].menuId;
    			themenudata[j] = lstmenudata[i];
    			j++;
    		}
    	}
		var source =
		{
			dataType: "json",
			datafields:  [
                { name: 'menuName', type: 'String' },
                { name: 'menuId', type: 'String' },
                { name: 'roleMenuId', type: 'String' }
            ],
           	id: 'id',
           	localdata: themenudata
        };
        // 初始化数据列表
        var dataAdapter = new $.jqx.dataAdapter(source);
        $("#resourcejqxgrid").jqxGrid(
        {             
            //width: document.body.clientWidth,
            source: dataAdapter,           
            filterable: true,
            showfilterrow: true,
            pageable: true,
            width:500, 
            //autoheight: true,
            sortable: true,
            columnsresize: true,
            columns: [
              { text: '资源名称', datafield: 'menuName', width: 250},
              { text: '资源ID', datafield: 'menuId', width: 250},
              { text: '角色资源ID', datafield: 'roleMenuId', width: 500, hidden:true}
             ]
        });
        
    };
    