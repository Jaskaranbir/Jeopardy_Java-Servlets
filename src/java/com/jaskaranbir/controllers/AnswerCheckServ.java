/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.controllers;

import com.jaskaranbir.beans.Player;
import com.jaskaranbir.beans.Question;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jaska
 */
@WebServlet(name = "AnswerCheckServ", urlPatterns = {"/AnswerCheckServ"})
public class AnswerCheckServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Player player = (Player) session.getAttribute("player");
        Question ques = (Question) session.getAttribute("curQuestion");
        
        int val = ques.getValue();
        ques.setValue(0);
        
        int oldWins = player.getWins();
        
        String ans = request.getParameter("ans");
        
        if (ans != null && val > 0) {
            int scoreDelta = ans.equals(ques.getROption()) ? val : -val;
            player.setWins(player.getWins() + scoreDelta);
            
            if (scoreDelta > 0) {
                request.setAttribute("scoreDelta", "+$" + scoreDelta);
                request.setAttribute("scoreDeltaClass", "qRight");
            }
            else {
                request.setAttribute("scoreDelta", "-$" + -scoreDelta);
                request.setAttribute("scoreDeltaClass", "qWrong");
            }
        }
        else {
            request.setAttribute("scoreDeltaClass", "");
        }
        
        request.setAttribute("oldWins", oldWins);
        request.getRequestDispatcher((int) session.getAttribute("qCount") == 25 ? "resultPage.jsp" : "board.jsp").forward(request, response);
    }

}
