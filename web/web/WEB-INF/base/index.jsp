<%--
  Created by IntelliJ IDEA.
  User: ever
  Date: 2022/8/5
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线交流系统</title>
    <style>
        h1 {
            padding: 0;
            margin: 0;
            text-align: center;
        }

        body {
            position: absolute;
            width: 100%;
            height: 100%;
        }
    </style>
    <style type="text/css">
        #loginDiv {
            width: 40%;
            height: 40%;
            border: 1px solid #ccc;
            position: absolute;
            left: 40%;
            top: 40%;
            margin-left: -50px;
            margin-top: -50px;
        }

        #a_form.aaaaa {
            position: absolute;
            left: 50%;
            right: 50%;
            transform: translate(-50%, -50%);
        }

    </style>

    <link rel="index" href="/resources/css/base.css">
</head>
<body>


<h1>欢迎来到在线交流系统</h1>


<div id="loginDiv">


    <form action="${pageContext.request.contextPath}/base/login" method="post" id="a_form">

        <label>账户名：</label><input type="text" name="name" placeholder="请输入账户" class="aaaaa" style="margin: auto">
        <p>
            <label>密码：</label><input type="password" name="password" placeholder="请输入密码" class="aaaaa"
                                     style="margin: auto">
        <p>
            <input type="submit" value="登录" class="aaaaa" style="margin: auto">
    </form>
    <b id=></b>
</div>
<script>

</script>
</body>
</html>
