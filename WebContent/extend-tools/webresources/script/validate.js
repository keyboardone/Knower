Array.prototype.max = function()
{
	var i, max = this[0];
	
	for( i = 1; i < this.length; i++ )
	{
		if( max < this[i] )
		{ 
			max = this[i];
		}
	}
	return max;
};

String.prototype.trim = function()
{
    return this.replace( /(^\s*)|(\s*$)/g, "" );
};

function isAlphaNumeric( strValue,boxObj,paramsObj)
{
	return checkExp( /^\w*$/gi, strValue );
}

function isDate( strValue,boxObj,paramsObj )
{
	if( isEmpty( strValue ) ) {return true;}

	if( !checkExp( /^\d{4}-[01]?\d-[0-3]?\d$/, strValue ) ) 
	{
		return false;
	}
	
	var arr = strValue.split( "-" );
	var year = arr[0];
	var month = arr[1];
	var day = arr[2];
	
	if(year<1900||year>2060)
	{
		return false;
	}

	if( !( ( 1<= month ) && ( 12 >= month ) && ( 31 >= day ) && ( 1 <= day ) ) )
	{
		return false;
	}
		
	if( !( ( year % 4 ) == 0 ) && ( month == 2) && ( day == 29 ) )
	{
		return false;
	}
	
	if( ( month <= 7 ) && ( ( month % 2 ) == 0 ) && ( day >= 31 ) )
	{
		return false;
	}
	
	if( ( month >= 8) && ( ( month % 2 ) == 1) && ( day >= 31 ) )
	{
		return false;
	}
	
	if( ( month == 2) && ( day >=30 ) )
	{
		return false;
	}
	
	return true;
}

function isShortDate( strValue,boxObj,paramsObj )
{
	var DATETIME = strValue;
	if( isEmpty( strValue ) ) return true;
	if( !checkExp(/^\d{4}-[01]?\d/g,DATETIME) )
	{
		return false;
	}

	var arr = DATETIME.split( "-" );
	var year = arr[0];
	var month = arr[1];
	if(year<1753)
	{
		return false;
	}

	if(arr.length==3)
	{
	   return false;
	}
	if( !((1<= month ) && ( 12 >= month )))
	{
		return false;				
	}
	
	return true;
}

function isEmail( strValue,boxObj ,paramsObj)
{
	if( isEmpty( strValue ) ) return true;
	
	var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	return checkExp( pattern, strValue );
	
}

function isNumeric( strValue,boxObj,paramsObj )
{
	if( isEmpty( strValue ) ) return true;
	if( !checkExp( /^[+-]?\d+(\.\d+)?$/g, strValue ))
	{
		return false;
	}
	return true;
}

function isMoney( strValue,boxObj,paramsObj )
{
	if( isEmpty( strValue ) ) return true;
	
	return checkExp( /^[+-]?\d+(,\d{3})*(\.\d+)?$/g, strValue );
}

function isPhone( strValue,boxObj )
{
	if( isEmpty( strValue ) ) return true;
	
	return checkExp( /(^\(\d{3,5}\)\d{6,8}(-\d{2,8})?$)|(^\d+-\d+$)|(^(130|131|135|136|137|138|139)\d{8}$)/g, strValue );
}

function isPostalCode( strValue,boxObj,paramsObj )
{
	if( isEmpty( strValue ) ) return true;
	if(!checkExp( /(^$)|(^\d{6}$)/gi, strValue ))
	{
		return false;
	}
	return true;
}

function isURL( strValue,boxObj ,paramsObj)
{
	if( isEmpty( strValue ) ) return true;
	
	var pattern = /^(http|https|ftp):\/\/(\w+\.)+[a-z]{2,3}(\/\w+)*(\/\w+\.\w+)*(\?\w+=\w*(&\w+=\w*)*)*/gi;
	// var pattern = /^(http|https|ftp):(\/\/|\\\\)(\w+\.)+(net|com|cn|org|cc|tv|[0-9]{1,3})((\/|\\)[~]?(\w+(\.|\,)?\w\/)*([?]\w+[=])*\w+(\&\w+[=]\w+)*)*$/gi;
	// var pattern = ((http|https|ftp):(\/\/|\\\\)((\w)+[.]){1,}(net|com|cn|org|cc|tv|[0-9]{1,3})(((\/[\~]*|\\[\~]*)(\w)+)|[.](\w)+)*(((([?](\w)+){1}[=]*))*((\w)+){1}([\&](\w)+[\=](\w)+)*)*)/gi;

	return checkExp( pattern, strValue );
	
}
function trim(strValue)
{
	if(!strValue||strValue=='') return strValue;
	while(strValue.substring(0,1)==' ')
	{
		strValue=strValue.substring(1);
	}
	if(strValue=='') return strValue;
	while(strValue.substring(strValue.length-1,strValue.length)==' ')
	{
		strValue=strValue.substring(0,strValue.length-1);
	}
	return strValue;
}

function isNotEmpty( strValue,boxObj,paramsObj )
{
	strValue=trim(strValue);
	if( !strValue||strValue == '' )
		return false;
	else
		return true;
}

function isEmpty( strValue,boxObj,paramsObj )
{
	strValue=trim(strValue);
	if( strValue == "" )
		return true;
	else
		return false;
}

function openPositionPage(url,sourceBoxObj){
	return url;
}
var str= "";
function testcallbacufunc(pageid,reportid,selectedTrObjArr,deselectedTrObjArr)
{
	
		str=getTrObjsValue(selectedTrObjArr);
		if(str.lastIndexOf(',')==str.length-1) str=str.substring(0,str.length-1);
		window.parent.document.getElementById("RiskMeasureList_guid_RP_RiskMeasureDetail_wxcol_REPORTNAME").value=str;
	
}
var str1= "";
function testcallbacufunc1(pageid,reportid,selectedTrObjArr,deselectedTrObjArr)
{
	if(str1==""){
		str1=getTrObjsValue1(selectedTrObjArr);
	}else{
		if(str1.lastIndexOf(',')==str1.length-1) str1=str1.substring(0,str1.length-1);
		str1=str1+"/"+getTrObjsValue1(selectedTrObjArr);
	}
	if(str1!=null&&str1!='')
	{
		//alert(str1);
		window.parent.document.getElementById("RiskMeasureList_guid_RP_RiskMeasureDetail_wxcol_POSITIONVALUE").value=str1;
	}	
}

var str2= "";
function testcallbacufunc2(pageid,reportid,selectedTrObjArr,deselectedTrObjArr)
{
	if(str2==""){
		str2=getTrObjsValue2(selectedTrObjArr);
		if(str2.lastIndexOf(',')==str2.length-1) str2=str2.substring(0,str2.length-1);
	}
	if(str2!=null&&str2!='')
	{
		//alert(str2);
		if(window.parent.document.getElementById("RiskMeasureList_guid_RP_RiskMeasureDetail_wxcol_RISKSETTING")){
			window.parent.document.getElementById("RiskMeasureList_guid_RP_RiskMeasureDetail_wxcol_RISKSETTING").value=str2;
		}
		if(window.parent.document.getElementById("stressTestUserDefinePage_guid_stressTestInterestRateDetail1_wxcol_RISKSETTING__1")){
			window.parent.document.getElementById("stressTestUserDefinePage_guid_stressTestInterestRateDetail1_wxcol_RISKSETTING__1").value=str2;
			//window.parent.document.getElementById("stressTestUserDefinePage_guid_stressTestInterestRateDetail1_wxcol_RISKSETTING__2").value=str2;
			//window.parent.document.getElementById("stressTestUserDefinePage_guid_stressTestInterestRateDetail1_wxcol_RISKSETTING__3").value=str2;
		}	
	}
}

function getTrObjsValue(trObjsArr)
{
	if(trObjsArr==null||trObjsArr.length==0) return '';
	var str='';
	for(var i=0;i<trObjsArr.length;i++)
	{
		var tdChilds=trObjsArr[i].getElementsByTagName('TD');
		for(var j=0;j<tdChilds.length;j++)
		{
			var name=tdChilds[j].getAttribute('value_name');// 
			var value=tdChilds[j].getAttribute('value');// 
			if(name&&name!=''&&name=='EN_NAME')
			{
				str=str+value;
			}
		}
	}
	return str;
}

function getTrObjsValue1(trObjsArr)
{
	if(trObjsArr==null||trObjsArr.length==0) return '';
	var str='';
	for(var i=0;i<trObjsArr.length;i++)
	{
		var tdChilds=trObjsArr[i].getElementsByTagName('TD');
		for(var j=0;j<tdChilds.length;j++)
		{
			
			var name=tdChilds[j].getAttribute('value_name');//获取当前列对应的<col/>的列名
			var value=tdChilds[j].getAttribute('value');//获取选中行的当前列的数据
			if(name&&name!='')
			{
				if(name=='SECURITYNAME'||name=='NOTIONAL'||name=='BONDPRICE'||name=='L_DATE')
				str=str+value+",";
			}
		}
	}
	return str;
}

function getTrObjsValue2(trObjsArr)
{
	if(trObjsArr==null||trObjsArr.length==0) return '';
	var str='';
	for(var i=0;i<trObjsArr.length;i++)
	{
		var tdChilds=trObjsArr[i].getElementsByTagName('TD');
		for(var j=0;j<tdChilds.length;j++)
		{
			
			var name=tdChilds[j].getAttribute('value_name');//获取当前列对应的<col/>的列名
			var value=tdChilds[j].getAttribute('value');//获取选中行的当前列的数据
			if(name&&name!='')
			{
				if(name=='ID'||name=='VALUATIONSPECNAME'||name=='ANALYSISDATE'||name=='PRICINGDATE'||name=='STATISTICSSTARTDATE'
					||name=='BASECURRENCY'||name=='DECAYFACTOR'||name=='ANALYSISHORIZON'||name=='RETURNHORIZON'||name=='DAYSOVERLAPRETURNHORIZON')
				str=str+value+",";
			}
		}
	}
	return str;
}

function testonload(pageid,componentid)
{
	alert('加载完页面ID：'+pageid+'；组件ID：'+componentid);
}
function initReport(reportname){
	
	alert("gaga");
}
 

