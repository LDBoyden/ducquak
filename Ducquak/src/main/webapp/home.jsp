<%-- 
    Document   : home
    Created on : 25-Nov-2015, 12:40:34
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
                    <h2 >Home Feed</h2>
                </div>

            </div>
            <div class="row margin-bottom">
                <div class="col-xs-12">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default center-block" aria-label="Create New Thread" onclick="location.href = 'newThread.jsp';">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true">  Create New Thread</span>

                        </button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="/headerFooter/footer.jsp" />
</html>
