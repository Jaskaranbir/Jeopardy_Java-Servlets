/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.controllers;

import com.jaskaranbir.beans.Question;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "QuestionServ", urlPatterns = {"/QuestionServ"})
public class QuestionServ extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        session.setAttribute("firstRun", 1);
        
        ArrayList<Question> ques = (ArrayList) session.getAttribute("questions");
        int qIndex = Integer.parseInt(request.getParameter("qIndex"));
        
        Question q = ques.get(qIndex);
        session.setAttribute("curQuestion", q);
        
        int[] dailyDoubles = (int[]) session.getAttribute("dailyDouble");
        
        if(q.isValid()){
            int qCount = (int) session.getAttribute("qCount");
            session.setAttribute("qCount", ++qCount);
            q.setInvalid();
            
            request.getRequestDispatcher(qIndex == dailyDoubles[0] || qIndex == dailyDoubles[1] ? "DailyDouble.jsp" : "question.jsp").forward(request, response);
        }
        
        else
            request.getRequestDispatcher("board.jsp").forward(request, response);
    }

}
