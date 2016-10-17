<%-- 
    Document   : AbstractQuestion
    Created on : 8-Oct-2016, 11:54:26 PM
    Author     : jaska
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="styles/question_style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu|Roboto|Baloo" rel="stylesheet">

<div id="wrapper">
    <h2 id="ques"><%= qu.getQuestion()%></h2>


    <form action="AnswerCheckServ" id="form">
        <div id="radioButtons">

            <table>
                <tr>
                    <td>                        
                        <%
                            String[] opts = qu.getAnswers();
                            int[] optSeq = (int[]) session.getAttribute("optSeq");
                        
                            for (int i = 1; i < qu.getAnswers().length + 1; i++) {
                        %>
                        <div>
                            <input type="radio" class="radio" name="ans" value="<%= optSeq[i-1] + 1%>" id="<%= optSeq[i-1]%>" required />
                            <label for="<%= optSeq[i-1]%>"><span></span><%= opts[optSeq[i-1]]%></label>
                        </div>

                        <%
                            }
                        %>
                    </td>
                    <td>
                        <div id="circle-svg">
                            <svg width="315" height="315">
                                <circle r="152" cx="50%" cy="50%" id="countdown-circle"/>
                                <text x="50%" y="50%" text-anchor="middle" alignment-baseline="central" id="countdown-text">15</text>
                            </svg>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <div id="button-container">
            <table>
                <tr>
                    <td><input type="submit" class="button" value="Submit"></td>
                    <td class="right-align"><input type="submit" class="button" id="skipButton" value="Skip"></td>
                </tr>
            </table>
        </div>
    </form>
</div>

<script type="text/javascript">
    var countdownText = document.getElementById("countdown-text");
    var countdown = 20;
    
    if(window.innerWidth > 719)
        setInterval(function(){
            countdownText.textContent = --countdown;
            switch(countdown){
                case 0: submitForm();
                case 10: countdownText.setAttribute("class", "countdown-danger");
            }
        }, 1000);

    var skipButton = document.getElementById("skipButton");
    skipButton.addEventListener("click", function () {
        submitForm();
    });
    
    function submitForm() {
        var inputs = document.getElementsByTagName("input");
        for (var i = 0; i < inputs.length - 2; i++) {
            inputs[i].required = false;
            inputs[i].checked = false;
        }

        document.getElementById("form").submit();
    }
</script>