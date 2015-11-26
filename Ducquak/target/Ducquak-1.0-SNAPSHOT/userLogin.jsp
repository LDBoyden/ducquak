<%-- 
    Document   : userLogin
    Created on : Nov 25, 2015, 1:04:29 PM
    Author     : NSERW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/headerFooter/headTop.jsp" />
    <jsp:include page="/headerFooter/headBottom.jsp" />
    <div class="container">

        <jsp:include page="/headerFooter/header.jsp"/>

        <script>
            var x = document.getElementById("errormessage");

            function getLocation()
            {
                if (navigator.geolocation)
                {
                    navigator.geolocation.getCurrentPosition(showPosition);
                } else
                {
                    x.innerHTML = "Geolocation is not supported by this browser.";
                }
            }

            function showPosition(position)
            {
                document.loginform.latsub.value = position.coords.latitude
                document.loginform.longsub.value = position.coords.longitude
                return true;
            }
        </script>
        <body>
            <h1>Hello World!</h1>
            <h2 id="errormessage"></h2>

            <p id="demo"></p>


            <div class="row">
                <div class="col-xs-6">
                    <form id="loginform" method="POST" action="userLogin">
                        <ul>
                            <li style="margin-bottom: 10px;">Username:  <input type="text" name="username"></li>
                            <li>Password: <input type="password" name="password" style="margin-left:4px;"></li>
                            <li class="hidden">Long <input type ="text" name="uLong" id="longsub" /></li>
                            <li class="hidden">Lat <input type ="text" name="uLat" id="latsub" /></li>
                        </ul>
                        <input type="submit" value="Login" onclick="getLocation()"> 
                    </form>
                </div>
            </div>
    </div>
    <jsp:include page="/headerFooter/footer.jsp" />
</body>
</html>
