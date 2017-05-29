var ww = window.screen.width;
var wh = window.screen.height;
var dw = ww-ww*0.3;
var dh = wh-wh*0.2;
var dleft = (ww-dw)/2;
var dtop = 30;
var div ;
var frameW;
//var imgW = document.createElement("IMG");
var closeBtn;
var closeBtnImg;
function showImg(imgSrc,event,serverfilepathcode,attachmentname){
var src = encodeURIComponent(imgSrc);
if(src==null||src==""){
  src = "/uploadfile/"+document.getElementById('page1_guid_report1_jl').value; 
}
if(!div){
	 div = document.createElement("DIV");
	 frameW = document.createElement("IFRAME");
//var imgW = document.createElement("IMG");
	 closeBtn = document.createElement("DIV");
	 closeBtnImg= document.createElement("IMG");
	 
	div.style.width=dw;
	div.style.height=dh;
	div.style.position="absolute";
	div.style.display = "";
	div.style.top = dtop;
	div.style.left = dleft;
	div.style.display="none"
	div.id="tempIDIDID";
	div.align="center";
	div.style.background="gray";
	closeBtn.style.width=20;
	closeBtn.style.height=20;
	closeBtn.style.position="absolute";
	closeBtn.style.top = dtop-20;
	closeBtn.style.left = dleft+dw-20;
	//closeBtn.style.background = "red";
	closeBtnImg.width=20;
	closeBtnImg.height=20;
	closeBtnImg.src="../webresources/skin/qq/images/prompt/err.gif";
	closeBtn.appendChild(closeBtnImg);
	closeBtn.onclick=function(){
		$(div).fadeOut("slow");
		//div.style.display="none";
		$(this).fadeOut("slow");
	};
	frameW.scrolling = "auto";
	frameW.width=dw;
	frameW.height = dh;
	frameW.src="/MRP/image.jsp?imageSrc="+src;
	//imgW.src=imgSrc;
	//imgW.id="tempIMGIMG";
	div.appendChild(frameW);
	div.appendChild(closeBtn);
	div.style.zIndex=1;
	//imgW.style.zIndex=2;
	closeBtn.style.zIndex=3;
	window.document.body.appendChild(div);
	window.document.body.appendChild(closeBtn);
}
$(div).fadeIn("slow",function(){
	closeBtn.style.display="";
});

	
}


function openDownLoadFile(serverfilepathcode,attachmentname){
    //alert(serverfilepathcode);
    if(attachmentname==null||attachmentname==""||attachmentname==undefined){
      attachmentname= document.getElementById('page1_guid_report1_jl').value; 
    }
    window.location.href="/MRP/ShowReport.wx?ACTIONTYPE=download&serverfilepath="+serverfilepathcode+"&serverfilename="+attachmentname;
}