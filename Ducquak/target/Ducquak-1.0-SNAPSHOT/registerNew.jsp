<%-- 
    Document   : registerNew
    Created on : Nov 24, 2015, 4:42:16 PM
    Author     : NSERW
--%>

<%@page import="Stores.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/headerFooter/headTop.jsp" />
    <jsp:include page="/headerFooter/headBottom.jsp" />
    <body>
        <div class="container">
        
        <jsp:include page="/headerFooter/header.jsp"/>
        
            <form method="POST" action="registerUser">
                <p> ${message}</p>
                <ul>
                    <li> User Name <input type="text" name="username"></li>
                    <li>Password  <input type="password" name="password"></li>
                    <li>Confirm Password <input type="password" name="password01"></li>
                </ul>
                <input type="submit" value="Register"> 
            </form>
        
        </div>
    </body>
     <jsp:include page="/headerFooter/footer.jsp" />
</html>
