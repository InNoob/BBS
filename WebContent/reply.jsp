<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- UEditor所需要的引用文件 -->
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="resource/js/ueditor.js"></script>
<link href="resource/css/ueditor.css" type="text/css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="resource/css/reset.css">
<link rel="stylesheet" type="text/css" href="resource/css/post_details.css">

<title>BoBoSi</title>
</head>
<body>
<%session.setAttribute("page", "reply.jsp"); %>
<c:if test="${empty topicInfo}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<%@ include file="toppanel.jsp" %>
          <c:if test="${empty bbsState}">
              <c:redirect url="SelectTopicByIdServlet?tid=${topicInfo.tid }"></c:redirect>
          </c:if>
          <c:remove var="bbsState" />
	<div id="main">
		<!-- 导航头 -->
		<!-- <div id="head_bar">
			
		</div> -->
		
		<!-- 主贴标题/用户信息 -->		
		<div class="thread_title">
			<div class="thread_info">
				<h1>${topicInfo.title }</h1>
			</div>
			<a href="#?uid=${topicInfo.uid }" target="_blank">
				<img src="./resource/image/pic.jpg" class="user_pic" >
			</a>
			<div class="user_info">
				<div class="author">
					<a href="#" target="_blank">${topicInfo.userName }</a><span> &nbsp; / &nbsp; ${topicInfo.recTime }</span>
				</div>
				<div class="counter">
					浏览：${topicInfo.flowCount } &nbsp; / &nbsp; 回复：${topicInfo.rcount }
				</div>
			</div>
		</div>
		
		<!-- 主贴内容 -->
		<div class="thread_content">
			<table cellspacing="0" cellpadding="0" class="t1">
				<tr style="height:100px;">
					<td>
						${topicInfo.content }
					</td>
				</tr>
			</table>
			<div class="cl_1">
				<a href="#editor">回复</a>
				<a href="#?tid=${topicInfo.tid }" class="cl_r">举报</a>
			</div>
		</div>

		<c:forEach items="${reciveInfo }" var="recive">
		<!-- 用户评论 -->
			<div class="post_comment">
				<div>
					<a href="#?uid=${recive.uid }" target="_blank">
						<img src="${recive.headimg }" class="user_pic" >
					</a>
					<a href="#" class="t_user" target="_blank">${recive.username }</a>
				</div>
				
				<!-- 用户评论信息 -->
				<div class="user_comment">
					<div>
					内容：${recive.content }
					</div>
				</div>
				<div class="cl_2">
					<a onclick="repliesReplyOpen('${recive.rid}','${recive.uid}','${recive.username}',0)">回复</a>
					<a href="#" class="cl_r">举报</a>
				</div>
				<c:forEach items="${recive.list}" var="rer">
					<div class="evaluat"><span><a href="javascript:repliesReplyOpen('${rer.rid}','${rer.uid}','${rer.username}',${rer.eid });">${rer.username }</a><c:if test="${!empty rer.beuid}"><span class="span2">回复</span>${rer.beuid }</c:if>:</span> ${rer.content  }</div>
				</c:forEach>
				<div></div>
			</div>
		</c:forEach>
		<!-- 分页 -->
		<div id="reply_page"></div>
		
		<!-- 评论编辑器 -->
		<div id="editor">
			<div class="lineHeight"></div>
			<!-- 回帖富文本框 -->
			<form action="ReciveTopicServlet" method="post" id="form1">
				<table align="center" id="content">
					<tr>
						<td><textarea id="replies-ueditor">
						</textarea></td>
					</tr>
					<tr>
						<td><input type="hidden" name="repliesContent" id="msg" /></td>
					</tr>
					<tr>
						<td>
							<button onclick="return getContent();" id="replies-Submit">提 交</button>
						</td>
					</tr>
				</table>
				<script>
				document.getElementById('replies-Submit').addEventListener("click", function() {
				    document.getElementById("topiccontent").value = UE.getEditor('newTopic-ueditor').getContent();
				    document.getElementById("form1").submit();
				    return false;
				}, false);
				</script>
			</form>
		</div>
		
		<!-- 底部栏 -->
		<div id="bottom_bar">
			
		</div>

	</div>

<!-- 回复富文本框 -->
<form action="EvaluatServlet" method="post" id="form2">
	<input type="hidden" name="rid" id="rid" />
	<input type="hidden" name="uid" id="uid" />
	<input type="hidden" name="eid" id="eid" />
	<input type="hidden" name="evaluatContent" id="evaluatMsg"/>
	<div id="replies-Reply-div">
		<input type="submit" id="replies-Reply-submit" onclick="return getReplyContent();" value="提交">
			<div id="replies-Reply-prompted">您回复了：<span id="username"></span></div>
			<textarea id="replies-Reply-ueditor">
			</textarea>
		<button id="replies-Reply-close" onclick="return repliesReplyClose()">X</button>
	</div>
	<div id="c"></div>
</form>
</body>
</html>