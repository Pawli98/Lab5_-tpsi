/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/tablica"})
public class tablica_Servlet extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
   {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        List<Student> tablica;
        String imie,nazwisko,email;
        Student nowy_dodaj;
            if (session.getAttribute("student_Tab") == null) 
            {
                tablica = new ArrayList<>();
            }
            else 
            {
                tablica = (List<Student>) session.getAttribute("student_Tab");
            }
            if (null != request.getParameter("imie")) 
            {
            imie = request.getParameter("imie");
            nazwisko = request.getParameter("nazwisko");
            email = request.getParameter("email");

            nowy_dodaj = new Student(imie, nazwisko, email);
                if(imie.length()!=0 && nazwisko.length()!=0 && email.length()!=0)
                {
                tablica.add(nowy_dodaj);
                }
                session.setAttribute("student_Tab", tablica);
            }
        
        try (PrintWriter out = response.getWriter()) 
        {
            request.getRequestDispatcher("tablica.jsp").forward(request, response);
        } 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        processRequest(request, response);

        HttpSession session = request.getSession();
        List<Student> tablica;
                
        if (session.isNew()) 
        {
        } 
        else { 
            if (null == session.getAttribute("student_Tab"))
            {
                tablica = new ArrayList<>();
            }
            else 
            {
                tablica = (List<Student>) session.getAttribute("student_Tab");
            }
            session.setAttribute("student_Tab", tablica);
       }
            
        try (PrintWriter out = response.getWriter()) 
        {
            request.getRequestDispatcher("tablica.jsp").forward(request, response);
        } 
        
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
