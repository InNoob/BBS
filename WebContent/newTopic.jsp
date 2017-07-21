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
<script type="text/javascript" src="resource/js/ajaxfram.js"></script>
<script type="text/javascript" src="resource/js/newTopicUeditor.js"></script>
<link href="resource/css/ueditor.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="resource/css/newTopic.css">
<title>发表帖子</title>
</head>
<body>
<%session.setAttribute("page", "newTopic.jsp"); %>
<c:if test="${empty user}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
 <%@ include file="toppanel.jsp" %>
<form action="NewTopicServlet" method="post" id="form1">
	<div id="overall">
		<!-- 板块选择 -->
		<div id="block">
		<div class="topic_title">板块:</div>
			<div class="block_item">
				<label for="technology">
					<input type="radio" id="technology" name="block" value="1"><span>技术交流</span>
				</label>&nbsp;&nbsp;&nbsp;
				<label for="everyday">
					<input type="radio" id="everyday" checked name="block" value="2"><span>日常生活</span>
				</label>&nbsp;&nbsp;&nbsp;
				<label for="resources">
					<input type="radio" id="resources" name="block" value="3"><span>资源共享</span>
				</label>&nbsp;&nbsp;&nbsp;
				<c:if test="${user.uid=='1011' }">
					<label for="official">
						<input type="radio" id="official" name="block" value="4"><span>官方公告</span>
					</label>
				</c:if>
			</div>
			<div class="high"></div>
			<!-- 标题 -->
			<div class="topic_title">标题:</div>
			<div class="block_item">
				<input type="text" id="title" name="title">
			</div>
		</div>

		<!-- 发帖富文本框 -->
		<!-- 评论编辑器 -->
		<div id="editor">
			<!-- 回帖富文本框 -->
				<table align="center" id="content">
					<tr>
						<td><textarea id="newTopic-ueditor">
						</textarea></td>
					</tr>
					<tr>
						<td><input type="hidden" name="topicContent" id="topiccontent" /></td>
					</tr>
					<tr>
						<td>
							<button id="replies-Submit">发表帖子</button>
						</td>
					</tr>
				</table>
		</div>
	</div>
</form>
</body>
<script>  
document.getElementById('replies-Submit').addEventListener("click", function() {
    document.getElementById("topiccontent").value = UE.getEditor('newTopic-ueditor').getContent();
    document.getElementById("form1").submit();
    return false;
}, false);
</script>
</html>