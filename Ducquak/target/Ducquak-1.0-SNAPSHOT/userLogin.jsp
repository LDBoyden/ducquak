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

                <div class="col-sm-4 col-sm-offset-4">
                    <form name="loginform" class="form-signin" method="POST"  action="Login">
                        <h2 class="form-signin-heading">Login</h2>

                </div>
                <div class="col-sm-4">
                </div>

            </div>


            <div class="row">

                <div class="col-sm-4 col-sm-offset-4">                   
                    <input type="text" name="username" class="form-control" placeholder="username" required autofocus>              
                    <input type="password" name="password" class="form-control" placeholder="password" required autofocus> 
                    <input type ="text" name="uLong" id="longsub" class="hidden"  required autofocus/>
                    <input type ="text" name="uLat" id="latsub" class="hidden" required autofocus />
                </div>
                <div class="col-sm-4">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <button class="btn btn-lg btn-default btn-block" type="submit" value="Login">Sign in</button>

                </div>
            </div>
    </body>
    <jsp:include page="/headerFooter/footer.jsp" />

</html>