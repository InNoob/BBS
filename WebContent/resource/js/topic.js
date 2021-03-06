// 这个函数用来做所有对象的事件绑定，做了浏览器兼容，支持多事件绑定，
function AddListener(element,event,handle){
    try {
        // 支持firefox chrome ie9+ opera safari edge
        element.addEventListener(event,handle,false);
    } catch (error) {
        try {
            // 支持ie8765
            element.attachEvent('on'+event,headle);
        } catch (error) {
            // 支持远古浏览器但不支持多事件绑定
            element['on'+event]=handle;
        }
    }
}
var server;

// onreadystatchange的回调控制器
function loadAjax(url,callback){
    // 浏览器兼容
    if(window.XMLHttpRequest)
        server = new XMLHttpRequest();
    else
        server = new ActiveXObject('Microsoft.XMLHTTP');
    //绑定事件 
    AddListener(server,'readystatechange',callback);
    server.open('GET',url,true);
    server.send();
}
//onreadystatchange的回调控制器 post
function loadAjaxPost(url,callback){
    // 浏览器兼容
    if(window.XMLHttpRequest)
        server = new XMLHttpRequest();
    else
        server = new ActiveXObject('Microsoft.XMLHTTP');
    //绑定事件 
    AddListener(server,'readystatechange',callback);
    server.open('POST',url,true);
    server.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    server.send();
}



// 关注方法
function takeCare(e,uid){
    // 注册回调
	var url;
	if(e.innerText =="已关注"){
		url='TakeCareServlet?uid='+uid+'&care=1';
	}else{
		url='TakeCareServlet?uid='+uid+'&care=0';
	}
    loadAjax(url,function () {
        if(server.readyState== 4&&server.status== 200)
        e.innerText = server.responseText;
    });
}