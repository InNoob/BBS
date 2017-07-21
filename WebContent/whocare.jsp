<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>

		<head>
			<title>My JSP 'whocare.jsp' starting page</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">

			<link rel="stylesheet" type="text/css" href="resource/css/follow.css">


		</head>

		<body>
			<div class="container">
				<c:forEach items="${followlist}" var="users">
				<div class="followers-box">
					<div class="followersinfo">
						<div class="followershead-box">
							<a href="DoGetUserDetails?uid=${users.uid}"><img class="followershead" alt="error" src="${users.headimg }" title="Ta的主页"></a>
						</div>
						<div class="nameandgender">
							<div class="genders" id=genders>
								${users.gender}
							</div>
							<div id="username">${users.username }</div>
						</div>
					</div>
					<div class="followersinfo">
						<div id="level">Lv : ${users.level}</div>
					</div>
										<div class="followersinfo">
										<a href="DoGetUserDetails?uid=${users.uid }">
										<input type="button" value="Ta的主页" id="followdetails">
										</a>
										</div>
				</div>
				</c:forEach>
			</div>
		</body>

		</html>