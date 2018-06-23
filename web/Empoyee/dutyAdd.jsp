<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath }/">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">考勤管理</a></li>
        <li><a href="#">签到签退</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form id="signfm" action="sign.action" method="post">
        <input type="hidden" name="op" value="signin">
        <input type="hidden" name="id" value="${sessionScope.user.id}">

    <ul class="forminfo">
        <li><label>&nbsp;</label><input id="sign" name="sign" type="button" class="btn" value="签到"/> 每天签到一次，不可重复签到</li>
        <li><label>&nbsp;</label></li>
        <li><label>&nbsp;</label></li>
        <li><label>&nbsp;</label><input id="signout" name="signout" type="button" class="btn" value="签退"/>可重复签退，以最后一次签退为准</li>
    </ul>
    </form>

</div>


</body>

<script type="text/javascript">

    $(function () {
        $("#sign").click(function () {
             $("#signfm").submit();
             alert(req.getAttribute("msg"));

             //发送一个Ajax请求
            // $.ajax({
            //     type:"POST",
            //     data:{
            //         "op":"check",
            //         "checkcode":$("#checkcode").val()
            //     },
            //     url : "login.action",
            //     success : function (result) {
            //         console.log(result);
            //
            //         if(result){  //flag
            //             $("#fm").submit();
            //         }else{
            //             alert("验证码错误！");
            //         }
            //     }
            // })



        })
    })


</script>
</html>
