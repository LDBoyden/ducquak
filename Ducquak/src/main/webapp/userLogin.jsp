<%-- 
    Document   : userLogin
    Created on : Nov 25, 2015, 1:04:29 PM
    Author     : NSERW
--%>

<%@page import="Stores.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/headerFooter/headTop.jsp" />
    <jsp:include page="/headerFooter/headBottom.jsp" />
    <body onLoad="getLocation(loginform)">
        <div class="container">

            <jsp:include page="/headerFooter/header.jsp"/>

            <div class="row">
                <form name="loginform" method="POST" action="userLogin">
                    <ul>
                        <li>Username<input type="text" name="username"></li>
                        <li>Password<input type="password" name="password"></li>
                        <li class="hidden">Long<input type ="text" name="uLong" id="longsub" /></li>
                        <li class="hidden">Lat<input type ="text" name="uLat" id="latsub" /></li>
                    </ul>
                    <input type="submit" value="Login"> 
                </form>
            </div>

    </body>
    <jsp:include page="/headerFooter/footer.jsp" />
</div>
</html>