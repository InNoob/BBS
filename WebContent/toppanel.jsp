<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css">
<link rel="stylesheet" type="text/css" href="resource/css/myreset.css">
<link rel="stylesheet" type="text/css" href="resource/css/topic.css">
<script type="text/javascript" src="resource/js/topic.js"></script>
<script type="text/javascript" src="resource/js/ajaxfram.js"></script>
<script type="text/javascript">
	AddListener(window,'scroll',function() {
				var top = document.getElementById('topcontainer');
				var logo = document.getElementById('logo');
				var scrollTop = window.pageYOffset || document.documentElement.scrollTop || 
		        document.body.scrollTop || 0;

				if (scrollTop > 60) {
					top.className = 'top-scroll';
					logo.className = 'top-logoscroll';
					for (var i = 0; i < document.getElementsByClassName('top-blockinfo').length; ++i) {
						document.getElementsByClassName('top-blockinfo')[i].className = 'top-blockinfoscroll';
					}
				} else {
					top.className = 'top-container';
					logo.className = 'top-logo';
					// var e = document.getElementsByClassName('top-blockinfoscroll');
					for (var i = 0; i < document.getElementsByClassName('top-blockinfoscroll').length; ++i) {
						document.getElementsByClassName('top-blockinfoscroll')[i].className = 'top-blockinfo';
					}
				}
			});
</script>
</head>
<body>
	<core:if test="${empty topstate}">
		<core:redirect url="GetTopInfoServlet"></core:redirect>
	</core:if>
	<core:remove var="topstate"/>
	<div id="topcontainer" class="top-container">
		<div class="top-panel">
		<a href="index.jsp">
			<div id="logo" class="top-logo">
				<font color="orangered">B</font> <font color="gold">o</font> <font
					color="orangered">B</font> <font color="gold">o</font> <font
					color="dodgerblue">S</font> <font color="limegreen">i</font>
			</div></a>
			<div class="top-blockbox">
			<core:forEach items="${sessionScope.topcount }" var="item">
				<div " class="top-blockinfo">
					<a href="BlockServlet?bid=${item.bid }"><span>${item.blockName }</span></a> <span>发帖：${item.topCount }</span>
				</div>
			</core:forEach>
				<!-- <div id="top-block-technology" class="top-blockinfo">
					<a href="#"><span>技术交流</span></a> <span>发帖：999</span>
				</div>
				<div id="top-block-dailylife" class="top-blockinfo">
					<a href="#"><span>日常生活</span></a> <span>发帖：999</span>
				</div>
				<div id="top-block-resource" class="top-blockinfo">
					<a href="#"><span>资源分享</span></a> <span>发帖：999</span>
				</div>
				<div id="top-block-official" class="top-blockinfo">
					<a href="#"><span>官方公告</span></a> <span>发帖：999</span>
				</div> -->
			</div>
			<core:if test="${empty user }">
				<div class="top-headimgbox" style="display: none ">
			</core:if>
			<core:if test="${!empty user }">
				<div class="top-headimgbox" style="display: block ">
			</core:if>
				<div class="top-headimg ">
					<a href="userinfo.jsp"><img src="${refresh.headimg }" alt=""></a>
				</div>
				<span class="top-unread">${refresh.unread }</span>
				<div class="top-outuserinfo">
					<div class="top-userinfo">
						<div class="top-headimg top-innerheadimg">
							<a href="userinfo.jsp"> <img src="${refresh.headimg }" alt=""></a>
						</div>
						<b>${refresh.username }</b>
						<div style="width: 87%; margin: 20px auto; text-align: left">
							<span style="text-align: left">发帖：${refresh.topiccount }</span> <span
								style="width: 66%; text-align: right">点赞：${refresh.great }</span>
						</div>
						<div class="top-mark">
							<span>等级</span> 
								<span class="top-level"	style="background-position: -153px -${8+36*refresh.level}px;"></span>
								<span class="top-markbox"> <span class="top-markbar" style="width:${refresh.mark*100 / refresh.maxMark}%"></span>
							</span>
						</div>
						<div class="top-point">
							${refresh.mark }/<span style="color: #ccc">${refresh.maxMark }</span>
						</div>
						<div class="top-maskbar">
							<hr>
						</div>
						<div class="top-buttonbox">
							<div class="top-button">
								<a href="DoGetUserDetails"> <i class="top-i top-i-u"></i> <span>个人中心</span>
								</a>
							</div>
							<div class="top-button">
								<a href="DoGetUserDetails"> <i class="top-i top-i-m"></i> <span>消息提醒</span>
								</a>
							</div>
							<div class="top-button">
								<a href="DoGetUserDetails"> <i class="top-i top-i-t"></i> <span>我的帖子</span>
								</a>
							</div>
							<div class="top-button">
								<a href="DoGetUserDetails"> <i class="top-i top-i-f"></i> <span>我的收藏</span>
								</a>
							</div>
						</div>
						<div class="top-loginout">
							<a href="LoginOutServlet"><span>注销</span></a>
						</div>
					</div>
				</div>
			</div>
			<core:if test="${empty user }">
				<div class="top-sign" style="display: block">
			</core:if>
			<core:if test="${!empty user }">
				<div class="top-sign" style="display: none">
			</core:if>
				<a href="login.jsp"><span>登陆</span></a> <span>|</span> <a href="register.jsp"><span>注册</span></a>
			</div>
			<div class="top-searchbox">
				<input id="top-search" list="top-autocomple" name="" value="">
				<datalist id="top-autocomple">
				<option value="JasonBourne"></option>
				<option value="Well Smith"></option>
				<option value="Winter worth"></option>
				<option value="哈巴卵">habaluan</option>
				<option value="狗比">goubi</option>
				</datalist>
				<button type="button"></button>
			</div>
		</div>
	</div>
</body>
</html>