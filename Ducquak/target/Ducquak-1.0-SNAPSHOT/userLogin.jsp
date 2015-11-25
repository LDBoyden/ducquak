<%-- 
    Document   : userLogin
    Created on : Nov 25, 2015, 1:04:29 PM
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
                <form method="POST" action="userLogin">
                    <ul>
                        <li>Username<input type="text" name="username"></li>
                        <li>Password<input type="password" name="password"></li> 
                    </ul>
                    <input type="submit" value="Login"> 
                </form>
            
        </article>
    </body>
</html>
