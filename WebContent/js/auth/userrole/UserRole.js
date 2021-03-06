 $(document).ready(function () {
	//获取源数据
	 var lstdata ;
	 var roledt;
     getData();  
        /** 导出 */ 
        $("#excelExport").jqxButton();
        $("#excelExport").click(function () {
            $("#UserRolejqxgrid").jqxGrid('exportdata', 'xls', '角色管理');           
        });
        /** 删除 */      
        $("#delete").jqxButton();
        $("#delete").click(function ()  {
        	var rowindex = $("#UserRolejqxgrid").jqxGrid('getselectedrowindex');
			editrow = rowindex;
        	var dataRecord = $("#UserRolejqxgrid").jqxGrid('getrowdata', editrow); 
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
	        	var ID=dataRecord.id;
	        	var row = {id:ID};
	        	$.ajax({
	         	url: "../uResUserRoleMV/deleteUserRole/",
	         	type:'POST',                        
	        	async:false,
	        	data: row,
	         	dataType:"json"
	         	});
	            var rowid = $("#UserRolejqxgrid").jqxGrid('getrowid', rowindex);
	            $("#UserRolejqxgrid").jqxGrid('deleterow', rowid);//刷新
	            swal("删除成功!", "数据已删除!", "success");
	            getData();
            });
        });
        
        /** 新增 */
	    $("#increase").jqxButton();           
	    $("#increase").click(function (){
	    	 var rowindex = $("#Rolejqxgrid").jqxGrid('getselectedrowindex');
             editrow = rowindex;
             var offset = $("#Rolejqxgrid").offset();
             var dataRecord = $("#Rolejqxgrid").jqxGrid('getrowdata', editrow);
             roledt=dataRecord;
	    	$("#roleId").val(dataRecord.roleId);
	    	$("#roleName").val(dataRecord.roleName);
	    	//$("userCname").jqxDropDownList('setContent', 'Please Choose:');
	    	//var item = $('#userCname').jqxDropDownList('getItem', 0);
	    	//$("#userId").val(item.value);
	    	$("#popupWindowA").jqxWindow({ position:'center' });
	    	$("#popupWindowA").jqxWindow('show'); 
	    });
	    $("#Cancel").jqxButton();
	  //新增时候检验没有通过关闭框，错误弹框立即关闭  zlc
	    $('#popupWindowA').on('close', function (event) {
	    	$("#userId").jqxTooltip('close'); 
			});
	    $("#Save").jqxButton();
	    $("#popupWindowA").jqxWindow({ width: 300,height:220, resizable: false,  isModal: true, autoOpen: false,cancelButton: $("#Cancel"), modalOpacity: 0.01 });	    
	    $("#Save").click(function () {
	    	if($("#userId").val()==''){
	        	$("#userId").jqxTooltip({ content: "用户id必须输入!", position: 'right', autoHide: true, trigger: "none", closeOnClick: true });
	            $("#userId").jqxTooltip("open");
	            return;
	        }
	    	var item = $("#userCname").jqxDropDownList('getSelectedItem'); 
	    	var userId = item.value;
	    	var row = {
	    			userId:userId,
	    			roleId:$("#roleId").val(),
	           };	   
	    	$.ajax({
	    		url: getRealPath() +"/uResUserRoleMV/increaseUserRole",
	    		type:'POST',                        
	    		async:false,
	    		data: row,
	    		dataType:"json"
	     	});
	    	$("#popupWindowA").jqxWindow('hide');//关闭弹出页面
	    	$("#UserRolejqxgrid").jqxGrid('updatebounddata', 'cells');//刷新页面信息
	    	message("新增成功！");
	    	getData();
	    	loaduser(roledt.roleId);
	    });
 }); 
 
 /**加载所有数据*/
 var getData=function(){
 	$.ajax({
			url: "../uResUserRoleMV/selectRole",
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
				{ name: 'roleId', type: 'String' },
				{ name: 'roleName', type: 'String' },
         ],
        	id: 'id',
        	localdata: lstdata
     };
		 // 初始化数据列表
        var dataAdapter = new $.jqx.dataAdapter(source);
        $("#Rolejqxgrid").jqxGrid(
        {             
            width: 600,
            source: dataAdapter,           
            filterable: true,
            showfilterrow: true,
            pageable: true,
            autoheight: true,
            sortable: true,
            columnsresize: true,
            columns: [
				{ text: '角色id', datafield: 'roleId', width: 300},
				{ text: '角色名称', datafield: 'roleName', width: 300}
             ]
        });
        $("#Rolejqxgrid").click(function ()  {
        	var rowindex = $("#Rolejqxgrid").jqxGrid('getselectedrowindex');
            editrow = rowindex;
	        var offset = $("#Rolejqxgrid").offset();
	        var dataRecord = $("#Rolejqxgrid").jqxGrid('getrowdata', editrow);
	        theRoleId = dataRecord.roleId;
	        loaduser(theRoleId);
        });
        var userlist = selectUser();
		$("#userCname").jqxDropDownList({ source: userlist, displayMember: "userCname",valueMember: "userId", width: '170', dropDownHeight: 100});
		$('#userCname').on('select', function (event) {
	          var args = event.args;
	          var item = $('#userCname').jqxDropDownList('getItem', args.index);
	          if (item != null) {
	               $("#userId").val(item.value);
	          }
		});
 };
 function loaduser(theRoleId){
	    
 	//查询数据库结果，给lstdata，dataFieldsData，columnsData初始化数据
	    ajaxQuery(theRoleId);
	    
	   var source =
	    {
	        datatype: "json",
	        datafields:[
	                    { name: 'id', type: 'String' },
	                    { name: 'userId', type: 'String' },
	                    { name: 'userCname', type: 'String' },
	                    { name: 'roleId', type: 'String' },
	                    { name: 'roleName', type: 'String' }
	                ],
	        id: 'id',
	        type:'POST',
	         localData: lstdata
	    };
	    
	    var dataAdapter = new $.jqx.dataAdapter(source);
	    $("#UserRolejqxgrid").jqxGrid(
	    {
	        width: 600,
	        source: dataAdapter,  
	        filterable: true,
	        showfilterrow: true,
	        pageable: true,
	        autoheight: true,
	        sortable: true,
	        columnsresize: true,
	        columns:[
                     { text: 'ID', datafield: 'id', width: 195 ,hidden:true },
                     { text: '用户id', datafield: 'userId', width: 300},
                     { text: '用户名称', datafield: 'userCname', width: 300},
                    ]
			});
}
//ajax查询数据
function ajaxQuery(theRoleId){
    var params = {
         roleId:theRoleId
     };
     $.ajax({
         url:"../uResUserRoleMV/loadData/",
         type:'POST',                        
         async:false,
         data: params,
         dataType:"json",
		    success:function(data,textStatus){
				lstdata=data;
			},
			error:function(error,textStatus){ 
			}
 	});
 
 }

 