window.onload = function() {

    $("#container-login").css("margin-top", (window.innerHeight - 502) / 2 + 'px');
    var e = $('.lbl-boxmark');
    var a = $('.input-text');
    var line = $('.underline');
    if(null!=a[0])
    a[0].onfocus = function() {
        $('#' + e[0].id).addClass("lbl-boxmark-onhold");
        $('#' + e[0].id).removeClass("lbl-boxmark");
        a[0].focus();
        $('#' + line[0].id).addClass("underline-onhold");
        $('#' + line[0].id).removeClass("underline");
    }
    if(null!=a[1])
    a[1].onfocus = function() {
        $('#' + e[1].id).addClass("lbl-boxmark-onhold");
        $('#' + e[1].id).removeClass("lbl-boxmark");
        a[1].focus();
        $('#' + line[1].id).addClass("underline-onhold");
        $('#' + line[1].id).removeClass("underline");
    }
    if(null!=a[0])
    e[0].onclick = function() {
        $('#' + e[0].id).addClass("lbl-boxmark-onhold");
        $('#' + e[0].id).removeClass("lbl-boxmark");
        a[0].focus();
        $('#' + line[0].id).addClass("underline-onhold");
        $('#' + line[0].id).removeClass("underline");
    }
    if(null!=a[1])
    e[1].onclick = function() {
        $('#' + e[1].id).addClass("lbl-boxmark-onhold");
        $('#' + e[1].id).removeClass("lbl-boxmark");
        a[1].focus();
        $('#' + line[1].id).addClass("underline-onhold");
        $('#' + line[1].id).removeClass("underline");
    }
if(null!=a[0])
    a[0].onblur = function() {
        if (a[0].value != "")return;
        $('#' + e[0].id).addClass("lbl-boxmark");
        $('#' + e[0].id).removeClass("lbl-boxmark-onhold");
        $('#' + line[0].id).addClass("underline");
        $('#' + line[0].id).removeClass("underline-onhold");
    }
    if(null!=a[1])
    a[1].onblur = function() {
        if (a[1].value != "") return;
        $('#' + e[1].id).addClass("lbl-boxmark");
        $('#' + e[1].id).removeClass("lbl-boxmark-onhold");
        $('#' + line[1].id).addClass("underline");
        $('#' + line[1].id).removeClass("underline-onhold");
    }
    if (a[0].value != ""){
        $('#' + e[0].id).addClass("lbl-boxmark-onhold");
        $('#' + e[0].id).removeClass("lbl-boxmark");
        $('#' + line[0].id).addClass("underline-onhold");
        $('#' + line[0].id).removeClass("underline");
    }
    if (a[1].value != ""){
        $('#' + e[1].id).addClass("lbl-boxmark-onhold");
        $('#' + e[1].id).removeClass("lbl-boxmark");
        $('#' + line[1].id).addClass("underline-onhold");
        $('#' + line[1].id).removeClass("underline");
    }
    
}

function checkRegisterInput(){
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	if(reg.test(document.getElementById('user').value)){
		var xmlhttp;
		if(window.XMLHttpRequest()){
			xmlhttp = new XMLHttpRequest;	
		}else{
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET","RegisterInputServlet?email="+document.getElementById('user').value,true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				document.getElementById('message').innerText = xmlhttp.responseText;
			}
		}
	}
}

function chekeEmail(){
	var msg = document.getElementById('message');
	var ipt = document.getElementById('user').value;
	if(ipt==""){
		msg.innerText="邮箱不能为空";
		return false;
	}
	if(msg.innerText==""){
		var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if(reg.test(ipt)){
			return true;
		}else{
			msg.innerText="邮箱格式不正确";
			return false;
		}
	}
	return false;
}

function checkPwd(email){
	var msg = document.getElementById('message');
	var pass = document.getElementById("pass").value;
	var pass2 = document.getElementById("pass2");
	if(pass.length<6){
		msg.innerText = "密码不能少于6位字符";
		return false;
	}
	if(pass!=pass2.value){
		msg.innerText = "两次密码不一致";
		return false;
	}
	pass2.value = email;
	return true;
}

function checkLogin(){
	var msg = document.getElementById('message');
	var pass = document.getElementById("pass").value;
	var email = document.getElementById("email").value;
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	if(reg.test(email)==false){
		msg.innerText = "邮箱格式不正确";
		return false;
	}
	if(pass.length<6){
		msg.innerText = "密码不能少于6位字符";
		return false;
	}
	return true;
}