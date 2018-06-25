<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../themes/default/easyui.css" />
<link rel="stylesheet" href="../themes/icon.css" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"> 
	$(function(){
		$("#table").datagrid({
            "url":"emp.action",
            "title":"员工表明细",
            "queryParams":{"op":"selUser"},
            "columns":[[
                {field:'username',title:'用户名',width:100,align:'center'},
                {field:'name',title:'真实姓名',width:100,align:'center'},
                {field:'did',title:'所属部门编号',width:100,align:'center'},
                {field:'dname',title:'部门名称',width:100,align:'center'},
                {field:'jid',title:'所属岗位编号',width:100,align:'center'},
                {field:'jname',title:'岗位名称',width:100,align:'center'},
                {field:'hiredate',title:'入职时间',width:100,align:'center'},
                {field:'phone',title:'联系方式',width:100,align:'center'},
                {field:'contacts',title:'紧急联系人',width:100,align:'center'},
                {field:'mgr',title:'上级编号',width:100,align:'center'},
                {field:'rid',title:'角色编号',width:100,align:'center'}
            ]],
            "fitColumns":true,
            "striped":true,
            "rownumbers":true,
            "fit":true,
            "singleSelect":true,
            "toolbar": "#dg"
        });
      /*  // 加载所有的部门信息
        $("#dept").combobox({
            "url":"dept.action",
            "queryParams":{"op":"sel","some":"sel"},
            "textField":"name",
            "valueField":"id",
            "editable":false,
            "onLoadSuccess":function(){
                var a=$(this).combobox("getData");
                for(var items in a[0]){
                    if(items=="id"){
                        $(this).combobox("select",a[0][items])
                    }
                }
            }
        });*/
        //给查询按钮绑定点击事件
        $("#btnSearch").click(function(){
            $("#table").datagrid("load",{
                "url":"emp.action",
                "op":"selUser",
                "username":$("#username").val(),
               /* "did":$("#dept").val(),*/
                "isjob":$('input:radio:checked').val(),
                "hiredate":$("#hiredate").val()
            });
        });
        //给删除按钮绑定事件
        $("#btnDel").click(function(){
            var selected = $("#table").datagrid("getSelected");
            var msg="";
            if(selected==null) {
                msg = "请先选中，在进行删除操作";
                $.messager.alert("警告",msg,"warning");
            }else {
                $.messager.confirm("确认", "确认删除" + selected.name + "的用户信息吗？", function (r) {
                    if (r) {
                        $.get("emp.action", {"op": "delUser", "id": selected.id}, function (result) {
                            var msg = "";
                            if (result > 0) {
                                msg = "删除成功!";
                                $("#table").datagrid("reload");
                            } else {
                                msg = "删除失败";
                            }
                            $.messager.show({
                                "title": "系统消息",
                                "msg": msg,
                                "timeout": 2000,
                                "showType": "slide"
                            });
                        });
                    }
                });
            }
        });


        //给修改按钮绑定事件
        $("#btnUpd").click(function() {
            // 获取选中的行
            var selected = $("#table").datagrid("getSelected");
            if(selected == null) {
                $.messager.alert("警告", "请先选中再修改!", "warning");
            } else {
                // 显示修改窗口
                $("#updDl").dialog({
                    title: '修改用户表信息',
                    width: 400,
                    height: 400,
                    closed: false,
                    modal: true,
                    buttons: "#btn"
                });
              /*  // 修改用户信息时的部门下拉列表
                $("#did").combobox({
                    "url": "dept.action",
                    "queryParams": {"op": "sel"},
                    "textField": "name",
                    "valueField": "id",
                    "editable": false,
                    "onLoadSuccess": function () {
                        var val = $(this).combobox("getData");
                        for (var i = 0; i < val.length; i++) {
                            for (var item in val[i]) {
                                if (item == "id" && val[i][item] == selected.id) {
                                    $(this).combobox("select", val[i][item]);
                                }
                            }
                        }
                    }
                });
                // 修改用户信息时的部门下拉列表
                $("#jid").combobox({
                    "url": "job.action",
                    "queryParams": {"op": "selJob"},
                    "textField": "jname",
                    "valueField": "id",
                    "editable": false,
                    "onLoadSuccess": function () {
                        var val = $(this).combobox("getData");
                        for (var i = 0; i < val.length; i++) {
                            for (var item in val[i]) {
                                if (item == "id" && val[i][item] == selected.id) {
                                    $(this).combobox("select", val[i][item]);
                                }
                            }
                        }
                    }
                });*/
                //加载选中的用户信息
                $("#fm").form("load", selected);
            }
        });

        //给修改框中的修改按钮绑定事件
        $("#btnUpd1").click(function(){
            var selected = $("#table").datagrid("getSelected");
            $("#fm").form("submit", {
                "url":"emp.action",
                "queryParams":{"op":"updUser","id":selected.id},
                "success":function(data) {
                    var msg = "";
                    if(data > 0) {
                        msg = "修改成功!";
                        // 关闭修改窗口
                        $("#updDl").dialog("close");
                        // 刷新表格数据
                        $("#table").datagrid("reload");
                    } else {
                        msg = "修改失败!";
                    }
                    $.messager.show({
                        "title":"系统消息",
                        "msg":msg,
                        "timeout":2000,
                        "showType":"slide"
                    });
                }
            });
        });
        // 给取消按钮绑定事件
        $("#btnCancel").click(function() {
            $("#updDl").dialog("close");
        });
    });
</script>
</head>
<body>
<table id="table"></table>
<div id="dg">
	用户名：<input id="username" class="easyui-textbox"   style="width: 200px;" />
	<%--部门：<select name="dept" id="dept">
			<option value="1">总裁办</option>
			<option value="2">教学部</option>
			<option value="3">咨询部</option>
			<option value="4">教务部</option>
</select>--%>
	入职时间：<input id="hiredate" class="easyui-datebox"  style="width: 200px;" />
	是否在职：<span > <input type="radio" name="isjob" value="0" >否</input>
	<input type="radio" name="isjob" value="1" checked>是</input>
			</span>
	<a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
	<a id="btnUpd" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>
	<a id="btnDel" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
</div>
<div id="updDl">
	<center>
		<form id="fm" method="post" style="margin-top: 20px;">
			<table>
			<tr>
				<td>用户名:</td>
				<td><input class="easyui-textbox"  name="username" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input class="easyui-textbox"  data-options="readonly:true" name="name" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>部门编号:</td>
				<td>
					<select name="did1" id="did1">
						<option value="1">总裁办</option>
						<option value="2">教学部</option>
						<option value="3">咨询部</option>
						<option value="4">教务部</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>岗位编号:</td>
				<td>
					<select name="jid1" id="jdi1">
						<option value="1">总裁</option>
						<option value="2">教学经理</option>
						<option value="3">咨询经理</option>
						<option value="4">咨询师</option>
						<option value="4">人事专员</option>
						<option value="4">财务专员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>生日:</td>
				<td><input class="easyui-datebox" data-options="editable:false" name="birthday" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>入职日期:</td>
				<td><input class="easyui-datebox" data-options="editable:false" name="hiredate" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>联系人电话:</td>
				<td><input class="easyui-textbox"  name="phone" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>QQ:</td>
				<td><input class="easyui-textbox"  name="qq" style="width: 300px;" /></td>
			</tr>
			<tr>
				<td>紧急联系人:</td>
				<td><input class="easyui-textbox"  name="contacts" style="width: 300px;" /></td>
			</tr>
			</table>
		</form>
	</center>
</div>
<div id="btn">
	<a id="btnUpd1" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
	<a id="btnCancel" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
</div>
</body>
</html>