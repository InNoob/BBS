<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resource/css/normalize.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/myreset.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/userinfo.css" rel="stylesheet">
    <script type="text/javascript" src="resource/js/changeinfo.js"></script>
    <title>BoBoSi</title>
</head>

<body>
<% session.setAttribute("page", "otherinfo.jsp"); %>
<%@ include file="toppanel.jsp" %>
	<c:if test="${empty infostate}">
		<c:redirect url="DoGetUserDetails?uid=${user2.uid }"></c:redirect>
	</c:if>
	<c:remove var="infostate"/>
    <div class="containe" style="margin-top:100px">
        <div class="main">
	<!--<form action="dochangeinfo">  -->
            <div class="details-block">
                <div class="portrait-box">
                    <div class="img-box">
                        <div class="_img_ring"><img class="_img" src="${sessionScope.user2.headimg }" alt="error" title="点击更换头像"></div>
                    </div>
                    <div class="username-box">
                        <input type="text" name="username" class="infotext" id="username" value="${sessionScope.user2.username}"  />
                    </div>
                    <!--     <div class="mark">当前积分:<br/>${mark}</div> -->
                    <div class="level">Lv: ${sessionScope.user2.level}</div>
                </div>
                <div class="info-box" id="info-box">
                    <table class="details-table">
                        <tr>
                            <td class="left-td">UID：</td>
                            <td class="td-uid">
                                <input type="text" class="infotext" id="uid" value="${sessionScope.user2.uid}"  disabled /> 
                                <input type="hidden"  name="uid" value="${sessionScope.user2.uid}" />                 
                                 <c:if test="${sessionScope.user2.isfollowing==0 }">	
                                <a href="doinsertfollowing?uid=${user2.uid }" id="changeinfo-link"  >
                                <input type="button" name="changeinfo" class="changeinfo" id="changeinfo"  value="添加关注"   />
                                </a>
                                </c:if>
                                <c:if test="${sessionScope.user2.isfollowing==1 }">
                                <a href="DoUnfollowing?uid=${user2.uid }" id="changeinfo-link"  >
                                <input type="button" name="changeinfo" class="changeinfo" id="changeinfo"  value="取消关注"   />
                                </a>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td class="left-td">性别：</td>
                            <td>
                            <c:if test="${sessionScope.user2.gender=='男'}">
                            	男<span><input type="radio"  name="gender"  value="1" checked  disabled/></span>
                            	女<span><input type="radio"  name="gender" value="0"  disabled /></span>
                            	</c:if>
                            	 <c:if test="${sessionScope.user2.gender=='女'}">
                            	男<span><input type="radio"  name="gender"  value="1"    disabled/></span>
                            	女<span><input type="radio"  name="gender" value="0" checked  disabled/></span>
                            	</c:if>
                            	
                               <!-- <input type="text" name="gender" class="infotext" id="gender" value="${sessionScope.user.gender}" disabled /> --> 
                            </td>
                        </tr>
                        <tr>
                            <td class="left-td">生日：</td>
                            <td>
                                <input type="text" name="birth" class="infotext" id="birth" value="${sessionScope.user2.birthday}"  disabled/>
                            </td>
                        </tr>
                        <tr>
                            <td class="left-td">电子邮箱：</td>
                            <td>
                                <input type="text" name="email" class="infotext" id="email" value="${sessionScope.user2.email}"  disabled />
                            </td>
                        </tr>
                        <tr>
                            <td class="left-td">电话：</td>
                            <td>
                                <input type="text" name="mobile" class="infotext" id="mobile" value="${sessionScope.user2.phone}" disabled />
                            </td>
                        </tr>
                        <tr>
                            <td class="left-td">注册时间：</td>
                            <td>
                                <input type="text" name="jointime" class="infotext" id="jointime" value="${sessionScope.user2.jointime}" disabled />
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
                            <textarea class="whatup" id="whatup" name="whatup"  disabled>${sessionScope.user2.whatup}</textarea>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="tag-box">
                    <div class="tag-titlebox">
                        <div class="tag-title">个人主页/备注</div>
                    </div>
                    <div class="tag-content-box">
                        <div class="tag-content">
                            <textarea class="tag" id="tag" name="tag"  disabled>${sessionScope.user2.tag }</textarea>
                        </div>
                    </div>
                </div>
                <div class="followers-box">
                    <div class="followlogo-box">
                        <div class="followlogo">Followers :</div>
                    </div>
                    <div class="followcount-box">
                        <div class="followcount">
                            <a href="towhocare?uid=${sessionScope.user2.uid}&how=whocare" class="link" title="关注他的" >${sessionScope.user2.whocare}</a>
                        </div>
                    </div>
                </div>
                <div class="following-box">
                    <div class="followlogo-box">
                        <div class="followlogo">Following :</div>
                    </div>
                    <div class="followcount-box">
                        <div class="followcount">
                            <a href="towhocare?uid=${sessionScope.user2.uid}&how=carewho" class="link" title="他关注的">${sessionScope.user2.carewho}</a>
                        </div>
                    </div>
                </div>
            </div>
         <!--</form>  -->   
            <div class="topic-block">
                <div class="topic-box"><img class="logo" src="resource/image/posting.png" alt="123" title="发帖总计">
                    <div class="count-box">
                        <div class="topiccount">
                            <a name="topiclinkposting" class="link" href="posting?uid=user.uid" title="发帖总计">
                               ${sessionScope.user2.topiccount}
                            </a>
                        </div>
                    </div>
                </div>
                <div class="approval-box"><img class="logo" src="resource/image/good.png" alt="123" title="收到的赞">
                    <div class="count-box">
                        <div class="topiccount">
                               ${sessionScope.user2.great}
                            </a>
                        </div>
                    </div>
                </div>
                <div class="collection-box"><img class="    logo" src="resource/image/collection.png" alt="123" title="收藏的帖子">
                    <div class="count-box">
                        <div class="topiccount">
                            <a class="link" href="collection?uid=user.uid" title="收藏的帖子">
                               ${sessionScope.user2.favourite}
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>