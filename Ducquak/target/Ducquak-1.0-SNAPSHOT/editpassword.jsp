<%-- 
    Document   : Editpassword
    Created on : Nov 26, 2015, 6:52:14 PM
    Author     : NSERW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="editPassword">
            <ul>
                <li> Username <input type="text" name="username"></li>
                <li> Old password <input type ="password" name="oldPassword"></li>
                <li> New Password <input type="password" name="newPassword"></li>
                <li> Confirm new Password <input type="password" name="confirmNewPassword"></li>
            </ul>
            <input type="submit" name="Change Password">
        </form>
    </body>
</html>
