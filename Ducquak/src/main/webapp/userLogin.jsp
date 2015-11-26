<%-- 
    Document   : userLogin
    Created on : Nov 25, 2015, 1:04:29 PM
    Author     : NSERW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>li.hidden{visibility:hidden;}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script>    
        var lati=0;
        var longi=0;
    
        function getPosition(position) 
        {
            lati= position.coords.latitude;
            longi = position.coords.longitude;   
        
            document.getElementById("longsub").value = longi;
            document.getElementById("latsub").value = lati;

        
        }

        function getLocation(loginform) 
        {
            if (navigator.geolocation) 
            {
                navigator.geolocation.getCurrentPosition(getPosition);
            } else 
            { 
                loginform.latsub.value = "3";
                loginform.longsub.value = "5";
                document.write("Geolocation is not supported by this browser.");
            }
        }

    
    </script>
    </head>
    <body onLoad="getLocation(loginform)">
        <h1>Hello World!</h1>
        <h2 id="errormessage"></h2>
        
        <p id="demo"></p>

    
        
        <article>
                <form name="loginform" method="POST" action="userLogin">
                    <ul>
                        <li>Username<input type="text" name="username"></li>
                        <li>Password<input type="password" name="password"></li>
                        <li class="hidden">Long<input type ="text" name="uLong" id="longsub" /></li>
                        <li class="hidden">Lat<input type ="text" name="uLat" id="latsub" /></li>
                    </ul>
                    <input type="submit" value="Login"> 
                </form>
            
        </article>
    </body>

</html>