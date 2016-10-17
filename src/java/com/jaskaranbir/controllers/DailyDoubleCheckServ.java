/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.controllers;

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
@WebServlet(name = "DailyDoubleCheckServ", urlPatterns = {"/DailyDoubleCheckServ"})
public class DailyDoubleCheckServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int betAmount = Integer.parseInt(request.getParameter("betAmount"));
        
        Question qu = (Question) session.getAttribute("curQuestion");
        qu.setValue(betAmount);        
        
        request.setAttribute("betValidated", "");
        request.getRequestDispatcher("DailyDouble.jsp").forward(request, response);
    }

}
