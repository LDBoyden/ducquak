<%@page import="Stores.LoggedInfo"%>
<div class="row header margin-bottom">
    <h3 >Duc Quak!</h3>


    <nav>
        <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="home.jsp">HOME</a></li>
                <%
                    LoggedInfo lg = (LoggedInfo) session.getAttribute("LoggedIn");
                    if (lg == null) {
                %>
            <li role="presentation"><a href="userLogin.jsp">Sign IN</a></li> 
            <li role="presentation"><a href="registerNew.jsp">Register</a></li>
            <%
                        }    else{
            %>
            <li role="presentation"><a href="Logout.java">Log OUT</a></li>
            <li role="presentation"><a href="#">My Threads</a></li>
            
            <%
                        }
            %>
        </ul>
    </nav>
</div>