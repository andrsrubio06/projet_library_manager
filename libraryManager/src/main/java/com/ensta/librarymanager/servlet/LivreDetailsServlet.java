package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import javax.management.relation.InvalidRelationServiceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.EmpruntServiceI;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.LivreServiceI;
import com.ensta.librarymanager.service.MembreService;
import com.ensta.librarymanager.service.MembreServiceI;

public class LivreDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    /** 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        LivreService livreService = LivreServiceI.getInstance();
        EmpruntService empruntService = EmpruntServiceI.getInstance();
        Livre livre = new Livre();
        List<Emprunt> emprunts = new ArrayList<>();
        
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            livre = livreService.getById(id);
            emprunts = empruntService.getListCurrentByLivre(id);    
        } catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
        }

        request.setAttribute("livre", livre);
        request.setAttribute("emprunts", emprunts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/livre_details.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        LivreService livreService = LivreServiceI.getInstance();
        
        try {
            livreService.update(new Livre(
            Integer.parseInt(request.getParameter("id")),
            request.getParameter("titre"),
            request.getParameter("auteur"),
            request.getParameter("isbn")
            ));
            
            response.sendRedirect("livre_details?id=" + request.getParameter("id"));
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        }

    }


}