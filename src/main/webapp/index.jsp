<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hello index!</title>
    </head>

    <body>
        <form action="/ServletLife/DB" method="post">
            First Name: <input type="text" name="firstName" /><br />
            Last Name: <input type="text" name="lastName" /><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>