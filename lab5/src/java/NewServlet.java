/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gp41370
 */
@WebServlet(urlPatterns = {"/Zliczanie"})
public class NewServlet extends HttpServlet 
{
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        
        int Zliczanie = 1;        
        HttpSession session = request.getSession();    
        
        if (null == session.getAttribute("Zliczanie")) 
        {
            Zliczanie = 1;
        } 
        else 
        {
            Zliczanie = (Integer) session.getAttribute("Zliczanie");
            Zliczanie++;
        }
        session.setAttribute("Zliczanie", Zliczanie);
        
        try (PrintWriter out = response.getWriter()) 
        {
            request.getRequestDispatcher("Zliczanie.jsp").forward(request, response);
        }
    }
}
