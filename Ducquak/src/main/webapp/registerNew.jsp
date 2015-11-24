<%-- 
    Document   : registerNew
    Created on : Nov 24, 2015, 4:42:16 PM
    Author     : NSERW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <article>
            <form method="POST" action="Register">
                <ul>
                    <li> User Name <input type="text" name="username"></li>
                    <li>Password  <input type="password" name="password"></li>
                    <li>Confirm Password <input type="password" name="password01"></li>
                </ul>
                <input type="submit" value="Register"> 
            </form>
        </article>
    </body>
</html>
