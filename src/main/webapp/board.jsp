<%@page import="java.util.ArrayList"%>
<%@page import="com.jaskaranbir.beans.Question"%>
<%@page import="com.jaskaranbir.beans.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Jeopardy</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/board_style.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700|Bitter" rel="stylesheet">
    </head>
    <body>
        <div id="bgDiv"></div>
        
        <div id="player-info">
            <%
                Player player = (Player) session.getAttribute("player");
                
                Object oldWinObj = request.getAttribute("oldWins");
                int oldWins = oldWinObj == null ? 0 : (int) oldWinObj;
            %>
            <div id="welcome-text">Welcome <%= player.getName()%></div>
            <div id="winnings">Winning: $<span id="winNum"><%=oldWins%></span></div>
        </div>

        <%
            String scoreDelta = ((String) request.getAttribute("scoreDelta"));
        %>
        <div id="winChange" class="<%= (String) request.getAttribute("scoreDeltaClass")%>">
            <%= scoreDelta == null ? "" : scoreDelta%>
        </div>

        <%
            String tableAnimClass = (String) request.getAttribute("tableAnimClass");
        %>

        <form action="QuestionServ">
            <div id="tableSVG">
                <svg xmlns="http://www.w3.org/2000/svg" width="1200" height="900" class="rectSVG <%= tableAnimClass%>">
                    <rect y="149" width="1200" height="750" id="whiteRect" />
                    <rect width="1200" height="147" id="redRect" />
                </svg>
            </div>
            <table>
                <tr class="tableHeader">
                    <th class="<%= tableAnimClass%>" >
                        Dora The Explorer
                    </th>
                    <th class="<%= tableAnimClass%>" >
                        Potato
                    </th>
                    <th class="<%= tableAnimClass%>" >
                        Study
                    </th>
                    <th class="<%= tableAnimClass%>" >
                        Game of Thrones
                    </th>
                    <th class="<%= tableAnimClass%>" >
                        Random Shoot
                    </th>
                </tr>

                <%
                    for (int i = 0; i < 5; i++) {
                %>
                <tr>
                    <%
                        ArrayList<Question> ques = (ArrayList) session.getAttribute("questions");
                        for (int j = 0; j < 5; j++) {
                            int index = i + (j * 5);
                            String type, dClass;
                            if (!ques.get(index).isValid()) {
                                type = "button";
                                dClass = " disabled";
                            }
                            else {
                                type = "submit";
                                dClass = "";
                            }
                    %>

                    <td>
                        <button name="qIndex" class="<%= tableAnimClass%>" type="<%= type%>" value="<%= index%>">
                            <svg width="240" height="150">
                                <text x="50%" y="50%" class="qValue <%= tableAnimClass + " " + dClass%>">
                                    <tspan text-anchor="middle" alignment-baseline="central" class="currencySign">$</tspan><tspan text-anchor="middle" alignment-baseline="central"><%= 200 * (i + 1)%></tspan>
                                </text>
                            </svg>

                        </button>
                    </td>

                    <%
                        }
                    %>
                </tr>

                <%
                    }
                %>
            </table>
        </form>
            
        <script>
            var tableSVG = document.getElementById("tableSVG");
            setTimeout(function(){
                    if("<%= tableAnimClass %>" != "")
                        tableSVG.className = "rectSVG";
                }, 2000);
            

            var scoreDiff = <%= player.getWins() - oldWins %>;
            var scoreField = document.getElementById("winNum");
            var curScore = parseInt(scoreField.textContent);
            
            document.getElementById("winNum").className = "win-num-anim";
            var playerWins = <%= player.getWins() %>;
            
            var scoreStep = Math.ceil(0.003 * scoreDiff);
            setInterval(function(){
                if((scoreDiff > 0 && curScore < playerWins) || (scoreDiff < 0 && curScore > playerWins)){
                    curScore += scoreStep;
                    scoreField.textContent = curScore;
                }
                else {
                    scoreField.textContent = playerWins;
                    document.getElementById("winNum").className = "";
                    clearInterval(this);
                }
            }, 4);            
        </script>
    </body>
</html>
