/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.controllers;

import com.jaskaranbir.beans.LoadGame;
import com.jaskaranbir.beans.Player;
import java.io.IOException;
import java.util.Random;
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
@WebServlet(name = "LoginServ", urlPatterns = {"/LoginServ"})
public class LoginServ extends HttpServlet {

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
        session.setAttribute("player", new Player(request.getParameter("name")));
        session.setAttribute("questions", new LoadGame().getQuestions());
        session.setAttribute("qCount", 0);
        
        Random rn = new Random();
        session.setAttribute("dailyDouble", new int[] {rn.nextInt(25), rn.nextInt(25)});
        
        request.setAttribute("tableAnimClass", "first-run");
        request.getRequestDispatcher("board.jsp").forward(request, response);
    }
}
