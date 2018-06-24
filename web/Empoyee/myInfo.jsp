<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath }/">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });

        });
	</script>
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">个人平台</a></li>
		<li><a href="#">我的信息</a></li>
	</ul>
</div>

<div class="formbody">

	<div class="formtitle"><span>个人信息</span></div>

	<ul class="forminfo">
		<li>
			<label>联系方式</label>
			<input name="" type="text" class="dfinput" value="${sessionScope.user.phone}"/>
		</li>
		<li>
			<label>QQ号</label>
			<input name="" type="text" class="dfinput" value="${sessionScope.user.qq}"/>
		</li>
		<li>
			<label>紧急联系人信息</label>
			<textarea name="" cols="" rows="" class="textinput">${sessionScope.user.contacts}</textarea>
		</li>
		<li>
			<label>&nbsp;</label>
			<input id="updBtn" name="upd" type="button" class="btn" value="修改信息"
				   onclick="window.location.href='Empoyee/updateInfo.jsp'"/>
		</li>
	</ul>

</div>

</body>

<script type="text/javascript">

        // $("#updBtn").on('click',function () {
			// window.location.href="./updateInfo.jsp";
        // })

</script>
</html>