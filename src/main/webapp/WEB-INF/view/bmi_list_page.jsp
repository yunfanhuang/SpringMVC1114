<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn"   uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI List Page</title>
    </head>
    <body style="padding: 20px">
        <h1>BMI List</h1>
        <h2>
            日期:
            <jsp:useBean id="now" class="java.util.Date" />
            <fmt:formatDate var="today" value="${ now }" pattern="yyyy/MM/dd H:m:s E" />
            ${ today }<br>
            日期:
            <fmt:formatDate var="today2" value="${ now }" pattern="yyyy/MM/dd a h:m:s E" />
            ${ today2 }
        </h2>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>資料</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${ list }">
                <tr>
                    <td>${ item }</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p />
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>身高</th>
                    <th>體重</th>
                    <th>BMI</th>
                    <th>BMI(小數點到第二位)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${ list }">
                <tr>
                    <td>${ item['h'] }</td>
                    <td>${ item['w'] }</td>
                    <td>${ item['bmi'] }</td>
                    <td>
                        <fmt:formatNumber var="bmi" pattern=".00" value="${ item['bmi'] }" />
                        ${ bmi }
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>