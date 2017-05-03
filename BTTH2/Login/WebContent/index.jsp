<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
     Cookie[] listCookie = request.getCookies();
     String user = "";
     String pass = "";
     String s="";
     if(listCookie.length>1) s="CHÀO MỪNG TRỞ LẠI";
     else s="";
     int co = 0;
     if(listCookie != null){
        while(co < listCookie.length){
          if(listCookie[co].getName().equals("user")){
            user = listCookie[co].getValue();
           }
          if(listCookie[co].getName().equals("pass")){
            pass = listCookie[co].getValue();
           }
          co++;
        }
  
      }
  %>
<form action ="LoginForm" method="post">
	<table>
		<tr> <p> <%= s %></p></tr>
		<tr>
			<td><label>UserName</label></td>
			<td><input type="text" name = "username" value= <%= user %>></td>
			
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="text" name = "password" value= <%= pass %>></td>
			
		</tr>
		<tr>
			<td><input type="submit" value = "Submit"></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>