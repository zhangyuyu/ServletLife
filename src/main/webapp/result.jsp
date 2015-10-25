<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>result</title>
    </head>
    <body>
     <table>
        <tr>
            <td>FirstName</td>
            <td>LastName</td>
        </tr>
        <c:forEach var="item" items="${customerList}">
            <tr>
               <td>${item.getFirstName()}</td>
               <td>${item.getLastName()}</td>
            </tr>
         </c:forEach>
     </table>

    </body>
</html>