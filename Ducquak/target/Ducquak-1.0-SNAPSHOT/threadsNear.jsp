<%-- 
    Document   : home
    Created on : 25-Nov-2015, 12:40:34
    Author     : arturpopov
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


            <div class="row margin-bottom">
                <div class="col-xs-12 center-block">
                    <h2 >My Threads</h2>
                </div>

            </div>
            <div class="row margin-bottom">
                <div class="col-xs-12">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default center-block" aria-label="Create New Thread" onclick="location.href = 'ThreadNearYou';">
                            <span class="glyphicon glyphicon glyphicon-refresh" aria-hidden="true">Threads Near You</span>

                        </button>
                    </div>
                    ${threadsNearYou}
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="/headerFooter/footer.jsp" />
</html>
