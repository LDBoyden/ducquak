<%-- 
    Document   : newThread
    Created on : 25-Nov-2015, 13:12:47
    Author     : arturpopov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/headerFooter/headTop.jsp" />
    <jsp:include page="/headerFooter/headBottom.jsp" />
    <body>
        <div class="container">

            <jsp:include page="/headerFooter/header.jsp"/>


            <div class="row margin-bottom">
                <div class="col-xs-12 center-block">
                    <h2 >Create a New Thread</h2>
                </div>

            </div>
            <div class="row margin-bottom">
                <form method="POST" action="registerUser">
                    <ul>
                        <li> User Name <input type="text" name="username"></li>
                        <li>Password  <input type="password" name="password"></li>
                        <li>Confirm Password <input type="password" name="password01"></li>
                    </ul>
                    <input type="submit" value="Register"> 
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="/headerFooter/footer.jsp" />
</html>
