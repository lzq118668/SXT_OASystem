

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="../../css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../../js/jquery.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>

	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">报销管理</a></li>
				<li><a href="#">查看具体报销项</a></li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="formtitle1"><span>具体报销项</span></div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>报销项编号<i class="sort"><img src="../../images/px.gif" /></i></th>
						<th>报销项类型</th>
						<th>报销项金额</th>
						<th>报销时间</th>
						<th>审核时间</th>
						<th>审核结果</th>
						<th>报销项说明</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sessionScope.reimItems}" var="r">
						<tr>
							<td>
								<input name="" type="checkbox" value="" />
							</td>
							<td>${r.id}</td>
							<td>${r.type}</td>
							<td>${r.money}</td>

							<td><f:formatDate value="${r.bDate}" pattern="yyyy年MM月dd日" ></f:formatDate></td>
							 <td><f:formatDate value="${r.auditDate}" pattern="yyyy年MM月dd日"></f:formatDate></td>
							<td>${r.auditResult}</td>
							<td>${r.remark}</td>

					    </tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
		<input name="" type="button" class="btn" value="返回" />
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
		
	</body>

</html>