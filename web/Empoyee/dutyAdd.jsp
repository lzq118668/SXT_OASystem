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

        <ul class="forminfo">
            <li><label>&nbsp;</label>
                <input id="sign" name="sign" type="button" class="btn" value="签到"/> 每天签到一次，不可重复签到
            </li>
            <li><label>&nbsp;</label></li>
            <input id="dissign" name="sign" type="button" class="btn-disable" value="已签到" disabled/> </li>
            <li><label>&nbsp;</label></li>
            <li><label>&nbsp;</label></li>
            <li><label>&nbsp;</label><input id="signout" name="signout" type="button" class="btn" value="签退"/>可重复签退，以最后一次签退为准
            </li>
        </ul>
    </form>

</div>


</body>

<script type="text/javascript">

    $(function () {

        //字符串拼接成当日的yyyy-MM-dd的日期格式。
        var flag;
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if ((month >= 1) && (month <= 9)) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate


        //页面加载判断是否签到。
        window.onload = function () {
            $.post(
                "sign.action",
                {
                    op: "signin",
                    id: "${sessionScope.user.id}",
                    mark: "no",
                    tdate: currentdate
                },
                function (result) {
                    console.log(result);
                    if (result == '2') {
                        $("#sign").show();
                        $("#dissign").hide();

                    } else {
                        $("#sign").hide();
                        $("#dissign").show();
                    }

                }
            );
        }


        $("#sign").click(function () {
            $.post(
                "sign.action",
                {
                    op: "signin",
                    id: "${sessionScope.user.id}",
                    mark: "ok"
                },
                function (result) {
                    if (result == 'yes') {
                        alert("签到成功");
                        $("#sign").hide();
                        $("#dissign").show();
                    } else {
                        alert(result);
                        alert("签到失败");
                    }
                }
            );
        })


        $("#signout").click(function () {
            $.post(
                "sign.action",
                {
                    op: "signout",
                    today:currentdate
                },
                function (result) {
                      alert(result);
                }
            );
        })


    })

</script>
</html>
