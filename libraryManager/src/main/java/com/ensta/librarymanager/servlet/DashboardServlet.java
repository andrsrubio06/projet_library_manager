package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.EmpruntServiceI;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.LivreServiceI;
import com.ensta.librarymanager.service.MembreService;
import com.ensta.librarymanager.service.MembreServiceI;

public class DashboardServlet extends HttpServlet {

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

        int numberOfLivres = 0;
        int numberOfMembres = 0;
        int numberOfEmprunts = 0;
        List<Emprunt> emprunts = new ArrayList<>();
        
		try {
            numberOfLivres = livreService.count();
            numberOfMembres = membreService.count();
            numberOfEmprunts = empruntService.count();
			emprunts =  empruntService.getListCurrent();
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        
		request.setAttribute("numberOfLivres", numberOfLivres);
		request.setAttribute("numberOfMembres", numberOfMembres);
		request.setAttribute("numberOfEmprunts", numberOfEmprunts);
		request.setAttribute("emprunts", emprunts);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/dashboard.jsp");
        dispatcher.forward(request, response);
    }
}