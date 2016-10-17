<%@page import="com.jaskaranbir.beans.Player"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jaskaranbir.beans.Question"%>
<%@page import="com.jaskaranbir.beans.Question"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <%@include file="Header.jsp" %>
        <link rel="stylesheet" href="styles/dailyDouble.css" />
        <link href="https://fonts.googleapis.com/css?family=Baloo" rel="stylesheet">
    </head>
    <body>
        <% 
            Player player = (Player) session.getAttribute("player");
            ArrayList<Question> ques = (ArrayList) session.getAttribute("questions");
            Question qu = (Question) session.getAttribute("curQuestion");
            
            boolean betValidated = request.getAttribute("betValidated") != null;
            String betFormAnimClass = betValidated ? "" : "betForm-anim";
        %>
        
        <div id="dailyDoubleForm <%= betFormAnimClass %>">
        <div id="DailyDouble-text" class="<%= betFormAnimClass %>"><%= betValidated? "You bet $" + qu.getValue() : "Daily Double!" %></div>
        
        <div id="bettingForm" class="<%= betFormAnimClass %>">
            <form action="DailyDoubleCheckServ" >
                <label class="betLabel" id="betLabelID" >Your bet:</label>
                <input type="number" name="betAmount" min="0" max="1000" id="betField" placeholder="Enter your Bet" required autofocus />
                <button type="submit" id="betButton">Enter</button>
            </form>
        </div>
        </div>
        
        <div class="form-container <%= betFormAnimClass %>">
            <%@ include file="AbstractQuestion.jsp" %>
        </div>
        
        <script>
            var betField = document.getElementById("betField");
            var playerWins = <%= player.getWins() %>;
            if(playerWins > 1000)
                betField.setAttribute('max', playerWins);
            
            betField.addEventListener("input", function() {
                document.getElementById("betLabelID").className = betField.value == "" ? "betLabel": "betLabel fadein-bottom";
            });
            
        </script>
    </body>
</html>
