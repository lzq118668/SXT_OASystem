<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src=../../js/jquery.js""></script>
    <script type="text/javascript">
         $(".btn").click(function () {
            var fm= document.getElementById("fm");
            fm.submit();
            alert("helloweodl");
         });
    </script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="dept.action?op=updDept" id="fm">
            <ul class="forminfo">
                <%
                    String id=request.getParameter("id");
                    String  dname=request.getParameter("dname");
                    String   loc=request.getParameter("loc");
                    pageContext.setAttribute("id",id);
                    pageContext.setAttribute("dname",dname);
                    pageContext.setAttribute("loc",loc);
                %>
            <li><label>部门编号</label><input name="id" type="text" class="dfinput" value="${pageScope.id}"/> </li>
            <li><label>部门名称</label><input name="dname" type="text" class="dfinput"  value="${pageScope.dname}"/></li>
            <li><label>办公地点</label><input name="loc" type="text" class="dfinput" value="${pageScope.loc}"/></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
