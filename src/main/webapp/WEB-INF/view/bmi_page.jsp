<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BMI</h1>
        <h2>身高 : ${ h }</h2>
        <h2>體重 : ${ w }</h2>
        <h2>${ bmi }</h2>
        <h2>${ requestScope.bmi }</h2>
        <h2><%=request.getAttribute("bmi") %></h2>
    </body>
</html>