<%@page import="com.jaskaranbir.beans.Player"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <%@include file="Header.jsp" %>
	<link rel="stylesheet" href="styles/resultPage_style.css" />
        <link href="https://fonts.googleapis.com/css?family=Baloo" rel="stylesheet">
    </head>
    <body>
	<% 
            Player player = (Player) session.getAttribute("player");
            int pScore = player.getWins();
	%>
		
	<div id="splash"></div>
		
	<div id="wrapper">
            <div id="game-over-text">Game Over!</div>
            <div id="money-text">You earned <%= pScore < 0 ? "-$" + -pScore : "$" + pScore %></div>
	</div>
        
        <script>
            document.addEventListener("click", function(){
                window.location.replace("index.html");
            })
        </script>
    </body>
</html>
