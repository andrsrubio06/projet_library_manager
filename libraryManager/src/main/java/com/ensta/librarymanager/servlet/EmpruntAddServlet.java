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

public class EmpruntAddServlet extends HttpServlet {

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
        MembreService membreService = MembreServiceI.getInstance();
        EmpruntService empruntService = EmpruntServiceI.getInstance();

        List<Membre> members = new ArrayList<>();
        List<Livre> livres = new ArrayList<>();

        
		try {
            livres = livreService.getListDispo();
            members = membreService.getListMembreEmpruntPossible();
    
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        
		request.setAttribute("ListOfBooks", livres);
		request.setAttribute("ListOfMembers", members);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/emprunt_add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        LivreService livreService = LivreServiceI.getInstance();
        MembreService membreService = MembreServiceI.getInstance();
        EmpruntService empruntService = EmpruntServiceI.getInstance();

        int livreByID = Integer.parseInt(request.getParameter("idLivre")); 
        int memberByID = Integer.parseInt(request.getParameter("idMembre")); 

        try {
            empruntService.create(livreByID, memberByID, LocalDate.now());

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
        }
        response.sendRedirect("emprunt_list");

    }


}