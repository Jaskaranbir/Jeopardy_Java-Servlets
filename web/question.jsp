<%@page import="java.util.ArrayList"%>
<%@page import="com.jaskaranbir.beans.Question"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Header.jsp" %>
    </head>
    <body>
        <% 
            Question qu = (Question) session.getAttribute("curQuestion");
        %>
        
        <%@include file="AbstractQuestion.jsp" %>
    </body>
</html>