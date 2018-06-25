<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>审核报销单</title>
		<link href="../../css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../../js/jquery.js"></script>
        <script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
		<script type="text/javascript">
			$(function () {

				$(".btn").click(function () {
					var form=document.getElementById("fm");

                       form.submit();
                })
            });
			
		</script>
	</head>

	<body>
        <%
		    String id=request.getParameter("id");
		    String  sid=request.getParameter("sid");
		    pageContext.setAttribute("id",id);
		   pageContext.setAttribute("sid",sid);

		%>
		<div class="formtitle"><span>审核报销单</span></div>
		<form action="../../auditAdd.action" id="fm" >
			<input type="hidden" name="id" value="${pageScope.id}"/>
			<input type="hidden" name="sid" value="${pageScope.sid}">
			<input type="hidden" name="op" value="auditAdd"/>

			<ul class="forminfo">
				<li>
					<label>审核结果</label>
					<input name="result" type="radio" value="通过" />通过
					<input name="result" type="radio"  value="未通过"/>拒绝
				<%--&ndash;<input name="result" type="radio" value="3"/>打回 &ndash;--%>
				</li>
				<li>
					<label>审核意见</label>
					<input name="mark" type="text" class="dfinput" />
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="btn" type="submit" class="btn" value="确认保存" id="btn"/>
				</li>
			</ul>
		</form>
	</body>

	</div>

</html>