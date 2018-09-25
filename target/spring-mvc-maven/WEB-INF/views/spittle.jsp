<%--
  Created by IntelliJ IDEA.
  User: liuxingwei
  Date: 8/20/18
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>
    <div class="spittleView">
        <div class="SpittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}" />
            </span>
        </div>
    </div>
</body>
</html>
