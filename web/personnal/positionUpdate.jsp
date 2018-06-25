<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改岗位信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <form action="../../job.action">
        <input name="op" type="hidden" value="updJob"/>
        <div class="formtitle"><span>基本信息</span></div>
            <%
                String id=request.getParameter("id");
                String  jname=request.getParameter("jname");
                String   jmark=request.getParameter("jmark");
                pageContext.setAttribute("id",id);
                pageContext.setAttribute("jname",jname);
                pageContext.setAttribute("jmark",jmark);
            %>
        <ul class="forminfo">
        <li><label>岗位编号</label><input name="id" type="text" class="dfinput"  readonly value="${pageScope.id}"/> </li>
        <li><label>岗位名称</label><input name="jname" type="text" class="dfinput" value="${pageScope.jname}"/> </li>
        <li><label>岗位描述</label><input name="jmark" type="text" class="dfinput"  value="${pageScope.jmark}"/></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
    
    </div>


</body>

</html>
