$(document).ready(function () {
    

});


function keyLogin(){

 if (event.keyCode==13)  //回车键的键值为13
			{
			dologin();
			}
};
function dologin(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("userpwd").value;
	var row = { userId: username, password: password};
	var error;
	$.ajax({
		url: getRealPath() +"/login.do",
		type:'POST', 
		datatype: "json",
		async: false,
		data: row,
		success:function(data){
			error=data;
		}
});
	if(error=="OK"){
		window.location.href="/KNOWER/loginIndex";
	}else{
		alert(error);
	}
	
    
	
}