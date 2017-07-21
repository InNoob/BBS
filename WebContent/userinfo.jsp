<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title></title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link href="resource/css/normalize.css" rel="stylesheet" type="text/css" />
            <link href="resource/css/myreset.css" rel="stylesheet" type="text/css" />
            <link href="resource/css/userinfo.css" rel="stylesheet">
            <script type="text/javascript" src="resource/js/changeinfo.js"></script>
            <script type="text/javascript" src="resource/js/jquery.min.js"></script>
            <script type="text/javascript" src="resource/js/ajaxfram.js"></script>
            <script type="text/javascript">
                function headclick() {
                    return $('#fileUpload').click();
                }
                // $("#userinfoimg").bind("click",function(){         
                //     return $('#fileUpload').click();
                // });
				var imgurl = "";  
				  
				function getImgURL(node) {    
				    var imgURL = "";      
				    var file = null;  
				    if(node.files && node.files[0] ){  
				        file = node.files[0];   
				    }else if(node.files && node.files.item(0)) {                                  
				        file = node.files.item(0);     
				    }     
				      
				    //这种获取方式支持IE10    
				    node.select();    
				    imgURL = document.selection.createRange().text;      
				    alert(imgURL);  
				      
				      
				    var textHtml = "<img src='"+imgURL+"'/>";     //创建img标签用于显示图片  
				    alert(textHtml);  
				    $(".mark").after(textHtml);  
				    return imgURL;  
				}  

                function uploadFile(obj, type) {
/*                     /*$.ajaxFileUpload({
                        url: "FileServlet",
                        secureuri: false, // 一般设置为false  
                        fileElementId: "fileUpload" + type, // 文件上传表单的id <input type="file" id="fileUpload" name="file" />  
                        dataType: 'json', // 返回值类型 一般设置为json  
                        data: {
                            'type': type,
                            "type2": 2
                        },
                        success: function(data) // 服务器成功响应处理函数  
                            {},
                        error: function(data) // 服务器响应失败处理函数  
                            {
                                console.log("服务器异常");
                            }
                    }); */
                    document.getElementById('fileForm').submit();
                    return false;
                }
			         
			</script>
			<title>BoBoSi</title>
        </head>

        <body>
            <% session.setAttribute("page", "userinfo.jsp"); %>
                <%@ include file="toppanel.jsp" %>
                    <c:if test="${empty infostate}">
                        <c:redirect url="DoGetUserDetails"></c:redirect>
                    </c:if>
                    <c:remove var="infostate" />
                    <div class="containe" style="margin-top:100px">
                        <div class="main">
                            <form action="dochangeinfo">
                                <div class="details-block">
                                    <div class="portrait-box">
                                        <div class="img-box">
                                            <div class="_img_ring">
                                                <img id="headimg" onclick="javascript:headclick();" style="cursor:pointer;" class="_img" src="${user.headimg }" alt="error" title="点击更换头像">
                                            </div>
                                           
                                        </div>
                                        <div class="username-box">
                                            <input type="text" name="username" class="infotext" id="username" value="${sessionScope.user.username}" />
                                        </div>
                                        <!--     <div class="mark">当前积分:<br/>${mark}</div> -->
                                        <div class="level">Lv: ${sessionScope.user.level}</div>
                                    </div>
                                    <div class="info-box" id="info-box">
                                        <table class="details-table">
                                            <tr>
                                                <td class="left-td">UID：</td>
                                                <td class="td-uid">
                                                    <input type="text" class="infotext" id="uid" value="${sessionScope.user.uid}" disabled /><input type="hidden" name="uid" value="${sessionScope.user.uid}" />
                                                    <a href="dochangeinfo" id="changeinfo-link">
                                                        <input type="submit" name="changeinfo" class="changeinfo" id="changeinfo" value="保存信息" /> </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="left-td">性别：</td>
                                                <td>
                                                    <c:if test="${user.gender=='男'}">
                                                        男<span><input type="radio"  name="gender"  value="1" checked  /></span> 女
                                                        <span><input type="radio"  name="gender" value="0"  /></span>
                                                    </c:if>
                                                    <c:if test="${user.gender=='女'}">
                                                        男<span><input type="radio"  name="gender"  value="1"    /></span> 女
                                                        <span><input type="radio"  name="gender" value="0" checked  /></span>
                                                    </c:if>

                                                    <!-- <input type="text" name="gender" class="infotext" id="gender" value="${sessionScope.user.gender}" disabled /> -->
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="left-td">生日：</td>
                                                <td>
                                                    <input type="text" name="birth" class="infotext" id="birth" value="${sessionScope.user.birthday}" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="left-td">电子邮箱：</td>
                                                <td>
                                                    <input type="text" name="email" class="infotext" id="email" value="${sessionScope.user.email}" disabled/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="left-td">电话：</td>
                                                <td>
                                                    <input type="text" name="mobile" class="infotext" id="mobile" value="${sessionScope.user.phone}" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="left-td">注册时间：</td>
                                                <td>
                                                    <input type="text" name="jointime" class="infotext" id="jointime" value="${sessionScope.user.jointime}" disabled />
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                    <div class="markbar-box">

                                    </div>
                                </div>
                                <div class="introduction-block">
                                    <div class="whatup-box">
                                        <div class="whatup-titlebox">
                                            <div class="whatup-title">
                                                个性签名
                                            </div>
                                        </div>
                                        <div class="whatup-content-box">
                                            <div class="whatup-content">
                                                <textarea class="whatup" id="whatup" name="whatup">${sessionScope.user.whatup}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="tag-box">
                                        <div class="tag-titlebox">
                                            <div class="tag-title">个人主页</div>
                                        </div>
                                        <div class="tag-content-box">
                                            <div class="tag-content">
                                                <textarea class="tag" id="tag" name="tag">${sessionScope.user.tag }</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="followers-box">
                                        <div class="followlogo-box">
                                            <div class="followlogo">Followers :</div>
                                        </div>
                                        <div class="followcount-box">
                                            <div class="followcount">
                                                <a href="towhocare?uid=${sessionScope.user.uid}&how=whocare" class="link" title="关注他的">${sessionScope.user.whocare}</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="following-box">
                                        <div class="followlogo-box">
                                            <div class="followlogo">Following :</div>
                                        </div>
                                        <div class="followcount-box">
                                            <div class="followcount">
                                                <a href="towhocare?uid=${sessionScope.user.uid}&how=carewho" class="link" title="他关注的">${sessionScope.user.carewho}</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                             <form action="FileServlet" id="fileForm" method="post"  enctype="multipart/form-data">
                                   <input id="fileUpload" type="file" name="fileName" onchange="javascript:uploadFile(this,1);" style="display:none">
                             </form>
                            
                            <div class="topic-block">
                                <div class="topic-box"><img class="logo" src="resource/image/posting.png" alt="123" title="发帖总计">
                                    <div class="count-box">
                                        <div class="topiccount">
                                            <a class="link" href="posting?uid=${user.uid}" title="发帖总计">
                               ${sessionScope.user.topiccount}
                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="approval-box"><img class="logo" src="resource/image/good.png" alt="123" title="收到的赞">
                                    <div class="count-box">
                                        <div class="topiccount">
                                            <a>
                               ${sessionScope.user.great}
                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="collection-box"><img class="    logo" src="resource/image/collection.png" alt="123" title="收藏的帖子">
                                    <div class="count-box">
                                        <div class="topiccount">
                                            <a class="link" href="collection?uid=user.uid" title="收藏的帖子">
                               ${sessionScope.user.favourite}
                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
        </body>

        </html>