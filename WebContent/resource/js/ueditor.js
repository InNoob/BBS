window.onload=function(){
	//实例化编辑器
	//UE.getEditor('myEditor');
	UE.getEditor('replies-ueditor',{
		toolbars:[[
			'source','|','undo','redo','|','bold','italic','underline'
			,'strikethrough','|','forecolor','|','removeformat','|',
	        'cleardoc','paragraph','|','fontfamily','fontsize'
	        ,'link','unlink','|','emotion','simpleupload','attachment',
	        '|','drafts','formula'
	    ]],
	    initialFrameWidth:1110,
	    initialFrameHeight:250,
	    autoHeightEnabled:false,
        elementPathEnabled:false,//是否启用元素路径，默认是显示
        emotionLocalization:true,
	});
	
	UE.getEditor('replies-Reply-ueditor',{
		initialFrameWidth:'100%',
		initialFrameHeight:200,
		toolbars:[['emotion']],
		autoHeightEnabled:false,
		elementPathEnabled:false,
		emotionLocalization:true,
	});
	
}

//获取TextArea的值
function getContent() {
	
	document.getElementById("msg").value=UE.getEditor('replies-ueditor').getContent();
	//document.cookie="message="+UM.getEditor('myEditor').getContent();
	//document.getElementById("c").innerHTML=UE.getEditor('replies-ueditor').getContent();
	document.getElementById("form1").submit();
	
	//document.getElementById("replies-Reply-div").style.display = "block";
	return false;
}


function repliesReplyClose(){
	document.getElementById("replies-Reply-div").style.display = "none";
	return false;
}

function repliesReplyOpen(rid,uid,username,eid){
	UE.getEditor('replies-Reply-ueditor').setContent("");
	document.getElementById("rid").value=rid;
	document.getElementById("uid").value=uid;
	document.getElementById("eid").value=eid;
	document.getElementById("username").innerText=username;
	document.getElementById("replies-Reply-div").style.display = "block";
}

function getReplyContent(){
	document.getElementById("evaluatMsg").value = UE.getEditor('replies-Reply-ueditor').getContent();
	return true;
}