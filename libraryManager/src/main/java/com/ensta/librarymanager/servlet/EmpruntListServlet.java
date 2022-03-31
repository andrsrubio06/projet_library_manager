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

public class EmpruntListServlet extends HttpServlet {

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
        String show = request.getParameter("show");
        
		try {
			if (show != null && show.equals("all")) {
                emprunts = empruntService.getList();
            } else {
                emprunts =  empruntService.getListCurrent();                
            }

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        
		request.setAttribute("emprunts", emprunts);
		
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/emprunt_list.jsp");
        dispatcher.forward(request, response);
    }
}