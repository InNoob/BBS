<%@page import="com.util.Pager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tpc" uri="/WEB-INF/topic.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resource/css/topic.css">
    <script type="text/javascript" src="resource/js/ajaxfram.js"></script>
    <title>BoBoSi</title>
</head>

<body>
    <%session.setAttribute("page","index.jsp"); %>
        <%@ include file="toppanel.jsp" %>
          <c:if test="${empty bbsState}">
              <c:redirect url="SelectByPageServlet"></c:redirect>
          </c:if>
          <c:remove var="bbsState" />
          <!-- 右边浮动栏 -->
          <div class="rightFloat_Bar">
             <a href="newTopic.jsp?uid=${user.uid }"><button class="rightFloat_item" id="addTopic">发帖</button></a>
             <button class="rightFloat_item" id="backTop" onclick="javascript:window.scrollTo(0,0);">Top</button>
         </div>

         <!-- 帖子 -->
        <div class="container">
            <c:forEach items="${pager.list}" var="t" varStatus="stat">
                <tpc:topic title="${t.title }" uid="${t.uid }" tid="${t.tid }" level="${t.level }" stat="${t.stat }" mark="${t.mark }" headimg="${t.headimg }" block="${t.block }" bid="${t.bid }" tpcTime="${t.topTime }" rcvTime="${t.newTime }" tpcUname="${t.userName }"
                    count="${t.rCount }" care="${t.care }" />
            </c:forEach>
        </div>
        <div class="pageno">
        <%
    	int no =((Pager)session.getAttribute("pager")).getTotalPage()/15;
        for(int i =0;i<=no;++i){
        	out.print("<a href='SelectByPageServlet?pageNo="+(i+1)+"'><span>["+(i+1)+"]</span></a>");
        }
        %>
        </div>
       <div class="footer">
			<b>©2017-2017 BoBoSi项目研发小组 湘ICP备17073693号-3</b>
       </div>

</body>
<script type="text/javascript" src="resource/js/topic.js"></script>
<script type="text/javascript">
</script>

</html>