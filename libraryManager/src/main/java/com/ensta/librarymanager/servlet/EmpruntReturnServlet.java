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

public class EmpruntReturnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    /** 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
      
        EmpruntService empruntService = EmpruntServiceI.getInstance();

        List<Emprunt> emprunts = new ArrayList<>();
        
		try {
            emprunts = empruntService.getListCurrent();
    
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        


		request.setAttribute("emprunts", emprunts);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/emprunt_return.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EmpruntService empruntService = EmpruntServiceI.getInstance();

        try {
            if (request.getParameter("id") == null) {
                throw new ServletException("Problème lors du retour du livre: vous devez sélectionner un livre");
            }

            int id = Integer.parseInt(request.getParameter("id")); 

            try {
                empruntService.returnBook(id);

            } catch (ServiceException e) {
                throw new ServletException(e.getMessage());
            }
            response.sendRedirect("emprunt_list");

        } catch (ServletException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
        }
    }


}