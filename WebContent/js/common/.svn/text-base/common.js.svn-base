/******************************
 * 公共JS类，提供本系统中一些公共方法
 *******************************/
/**获取工程的绝对路径*/
function getRealPath(){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol + "//" + localObj.host + "/"+ contextPath;
	return basePath ;
};
/**根据码类型获取下拉列表*/
var getCodeList =  function(codeType){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeController/getCodeListByType",
        type:'POST', 
        datatype: "json",
        data:"codeType="+codeType,
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};

/**根据rpt获取下拉列表*/
var selectMax =  function(rptId){
	var result;
	$.ajax({
	    url: getRealPath() + "/reportConfigController/selectMax",
        type:'POST', 
        datatype: "json",
        data:"rptId="+rptId,
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};

/**根据instId获取下拉列表*/
var selectLeaf =  function(instId){
	var result;
	$.ajax({
	    url: getRealPath() + "/InstController/selectLeaf",
        type:'POST', 
        datatype: "json",
        data:"instId="+instId,
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};


/**根据码类型获取下拉列表*/
var getCodeTypeList =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeController/getCodeType",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/**根据码类型获取下拉列表*/
var getCodeValueList =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeController/getCodeValue",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};


/**获取发行人名称*/
var getIssuerName =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeController/getDataByIssuerrating",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};

/**获取产品树树节点id*/
var getProductTreeNodeId = function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeController/getDataByProductId",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/**获取角色id和角色名称*/
var getRoleByRoleId = function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/ResRoleResourceController/getRoleByRoleId",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/**获取资源id和资源名称*/
var getMenuByMenuId = function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/ResRoleResourceController/getMenuByMenuId",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/** 获取用户表中的用户ID和名称 */
var selectUser =  function(id,defaulthtml){
	var userlist;
	$.ajax({
	    url: getRealPath() + "/uResUserRoleMV/selectUser",
        type:'POST', 
        datatype: "json",
        data: "id="+id,
        async: false,
        success:function(data,textStatus){
        	userlist = data;
		}
	});
	return userlist;
};
/** 获取角色表中的角色ID和名称 */
var selectRole =  function(id,defaulthtml){
	var rolelist;
	$.ajax({
	    url: getRealPath() + "/uResUserRoleMV/selectRole",
        type:'POST', 
        datatype: "json",
        data: "id="+id,
        async: false,
        success:function(data,textStatus){
        	rolelist = data;
		}
	});
	return rolelist;
};

var getSrcSystemList =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/codeMapping/getSrcSystem",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};



/** 根据码值ID获取码值名称 */
var getCodeNameById =  function(id){
	var codeName;
	$.ajax({
	    url: getRealPath() + "/codeController/getCodeNameById",
        type:'POST', 
        datatype: "json",
        data: "id="+id,
        async: false,
        success:function(data,textStatus){
        	codeName = data.codeValueDes;
		}
	});
	return codeName;
};
/** 根据码值ID获取码值名称标签 */
var getCodeNameTagById =  function(id,defaulthtml){
	var codeName;
	$.ajax({
	    url: getRealPath() + "/codeController/getCodeNameById",
        type:'POST', 
        datatype: "json",
        data: "id="+id,
        async: false,
        success:function(data,textStatus){
        	codeName = data.codeValueDes;
		}
	});
	var res = $(defaulthtml).html(codeName);
	return res[0].outerHTML;
};
//ajax
var ajaxQuery =  function(url,param){
	var result;
	$.ajax({
	    url: getRealPath() + url,
        type:'POST', 
        datatype: "json",
        data:param,
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/** 自定义过滤器 */
var addFilter = function (datafields){
    $("#jqxgrid").jqxGrid('clearfilters');
    $(datafields).each(function(index){
    	if($('#'+this).val()==''){
    		 return true;
    	}
		var filtergroup = new $.jqx.filter();
		var filtertype = 'stringfilter';
    	var filtervalue = $('#'+this).val();
    	var filtercondition = 'contains';
    	var filter_or_operator = 0;
    	var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
    	filtergroup.addfilter(filter_or_operator, filter);
    	$("#jqxgrid").jqxGrid('addfilter', this, filtergroup);
	});
		$("#jqxgrid").jqxGrid('applyfilters');
};

/** jqxValidator扩展校验-必须输入英文 */
var letterValidator= function (input) { 
	  var parent=/^[A-Za-z]+$/;
	  if(parent.test(input.val())){
          return true;
      }
      return false;
  };
/**校验-必须输入数字*/
  var letterValidatorData= function (input) { 
	  if(input.val()!=""){
	  var re = /^[0-9]+.?[0-9]*$/;
	  return re.test(input.val());
	  }
	  return true;
  };
/**日期格式转换*/
Date.prototype.Format = function (fmt) { 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
  };
var formatDate =function(value){
	if(value!="" && value != null){
	var res = new Date(value);
	return res.Format("yyyy/MM/dd");
	}return null;
};
/**0,1时显示中文*/
var smallPoints =function (value){
	if(value=="1"){
		return "是";
	}return "否";
};
function waringAlert(){
	swal({
		title: "Are you sure?",
		text: "确定要删除数据!",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: '#DD6B55',
		confirmButtonText: '是的, 删除!',
		closeOnConfirm: false
	},
	function(){
		swal("删除成功!", "数据已删除!", "success");
	});
}
//公共提示信息
//msg : 新增成功！,修改成功！
function message(msg){
		swal({					 
 		title: "",   
             text: msg,  
             type:'success', 
             timer: 2000,   
             showConfirmButton: true 
            });
}
/**PricingModel页面：refObjpropertyinxId下拉列表*/
var refObjpropertyinxIdData =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/PricingmodelController/refObjpropertyinxIdDropDown",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};
/**八位字符串类型日期转换*/
var formatStrDate =function(value){
	if(value!="" && value != null){
	var strDate = value.substring(0,4)+"/"+value.substring(4,6)+"/"+value.substring(6);
	return strDate;
	}return null;
};

/**获取定价模型id下拉列表*/
var getDifferentPricingmodelIdList =  function(){
	var result;
	$.ajax({
	    url: getRealPath() + "/PricingmodelController/getDifferentPricingmodelId",
        type:'POST', 
        datatype: "json",
        data:"",
        async: false,
        success:function(data,textStatus){
        	result = data;
		}
	});
	return result;
};