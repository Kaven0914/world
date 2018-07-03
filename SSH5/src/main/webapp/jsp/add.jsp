<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h2>ssh注解版整合</h2>
<s:debug></s:debug>
<form  method="post" action="/SSH5/add">
    姓名：<input type="text" name="studentSSH.name"><br />
   年龄：<input type="text" name="age"> <br />
    <input type="submit" value="添加">
</form>
</body>
</html>

