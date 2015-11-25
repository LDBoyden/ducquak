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
                <form method="POST" action="Threads">
                    <ul>
                        <li>Thread Name* <input type="text" name="threadname"></li>
                        <li>Description <input type="text" name="description"></li>
                        <li>Maximum Members<input type="text" name="maxmembers"></li>
                    </ul>
                    <input type="submit" value="Threads"> 
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="/headerFooter/footer.jsp" />
</html>
