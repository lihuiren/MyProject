<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div style="color: red;">  
        <strong>   
            <%  
            if(request.getAttribute("errmsg")!=null){  
                out.println(request.getAttribute("errmsg"));  
            }  
            %>  
        </strong>  
    </div>  
  <form action="<%=basePath%>Login" method="post">   
    用户登录：<br>
    账号：<input type="text" name="user"/><br>
    密码：<input type="password" name="pwd"/><br>
    <input type="submit" value="提交">
   <input type="text"  style="display:none" name="logInterface" value="<%=basePath%>">
    </form>
    <form action="<%=basePath%>Register" method="post">
    用户注册：
    账号：<input type="text" name="user"/><br>
    密码：<input type="password" name="pwd"/><br>
    请重复密码：<input type="password" name="pwdagain"/><br>
    <input type="submit" value="提交">
    </form>
    
    <form action="<%=basePath%>FilePhoto" enctype="multipart/form-data" method="post">
       	 上传文件：<input type="file" name="file1"><br/>
        <input type="submit" value="提交">
      </form>
      ${message}
  </body>
</html>
