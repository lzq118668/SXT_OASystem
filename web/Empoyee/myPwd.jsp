<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath }/">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">个人信息</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>

    <ul class="forminfo">
        <form id="pwdfm" action="login.action" method="post">
            <input type="hidden" name="op" value="selUserById">
            <input type="hidden" name="id" value="${sessionScope.user.id}">
            <li><label>旧密码</label><input id="opwd" name="opwd" type="password" class="dfinput"/><i><span></span></i>
            </li>
            <li><label>新密码</label><input id="npwd" name="npwd" type="password" class="dfinput"/><i></i></li>
            <li><label>新确认密码</label><input id="cnpwd" name="cnpwd" type="password" class="dfinput"/></li>
            <li><label>&nbsp;</label>
                <input id="subBtn" name="btn" type="button" class="btn" value="确认修改"/></li>
        </form>
    </ul>


</div>


</body>

<script type="text/javascript">
    $(function () {
        $("#subBtn").click(function () {
            $("#pwdfm").submit();
        })
    })
</script>
</html>
