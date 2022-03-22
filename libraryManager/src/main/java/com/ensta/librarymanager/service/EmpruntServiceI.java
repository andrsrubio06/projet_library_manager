package com.ensta.librarymanager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.dao.EmpruntDao;
import com.ensta.librarymanager.dao.EmpruntDaoI;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Membre;


public class EmpruntServiceI implements EmpruntService {
    private static EmpruntServiceI instance;

    private EmpruntServiceI() {}

    
    /** 
     * Returns the current instance
     * @return EmpruntService
     */
    public static EmpruntServiceI getInstance() {
        if(instance == null) {
            instance = new EmpruntServiceI();
        }
        return instance;
    }

    
    /** 
     * @return List<Emprunt>
     * @throws ServiceException
     */
    @Override
    public List<Emprunt> getList() throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        List<Emprunt> emprunts = new ArrayList<>();
        try {
            emprunts = empruntDao.getList();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return emprunts;
    }

    
    /** 
     * @return List<Emprunt>
     * @throws ServiceException
     */
    @Override
	public List<Emprunt> getListCurrent() throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        List<Emprunt> emprunts = new ArrayList<>();
        try {
            emprunts = empruntDao.getListCurrent();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return emprunts;
    }

    
    /** 
     * @param idMembre
     * @return List<Emprunt>
     * @throws ServiceException
     */
    @Override
	public List<Emprunt> getListCurrentByMembre(int idMembre) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        List<Emprunt> emprunts = new ArrayList<>();
        try {
            emprunts = empruntDao.getListCurrentByMembre(idMembre);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return emprunts;
    }

    
    /** 
     * @param idLivre
     * @return List<Emprunt>
     * @throws ServiceException
     */
    @Override
	public List<Emprunt> getListCurrentByLivre(int idLivre) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        List<Emprunt> emprunts = new ArrayList<>();
        try {
            emprunts = empruntDao.getListCurrentByLivre(idLivre);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return emprunts;
    }

    
    /** 
     * @param id
     * @return Emprunt
     * @throws ServiceException
     */
    @Override
	public Emprunt getById(int id) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        Emprunt emprunt = new Emprunt();
        try {
            emprunt = empruntDao.getById(id);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return emprunt;
    }

    
    /** 
     * @param idMembre
     * @param idLivre
     * @param dateEmprunt
     * @throws ServiceException
     */
    @Override
	public void create(int idMembre, int idLivre, LocalDate dateEmprunt) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        try {
            empruntDao.create(idMembre, idLivre, dateEmprunt);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
    }

    
    /** 
     * @param id
     * @throws ServiceException
     */
    @Override
	public void returnBook(int id) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        try {
            Emprunt emprunt = empruntDao.getById(id);
            emprunt.setDateRetour(LocalDate.now());
            empruntDao.update(emprunt);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
    }

    
    /** 
     * @return int
     * @throws ServiceException
     */
    @Override
	public int count() throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        int count = -1;
        try {
            count = empruntDao.count();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
        }
        return count;
    }

    
    /** 
     * @param idLivre
     * @return boolean
     * @throws ServiceException
     */
    @Override
	public boolean isLivreDispo(int idLivre) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        try {
           int count = empruntDao.getListCurrentByLivre(idLivre).size();
           return count == 0;
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return false;
    }

    
    /** 
     * @param membre
     * @return boolean
     * @throws ServiceException
     */
    @Override
	public boolean isEmpruntPossible(Membre membre) throws ServiceException {
        EmpruntDao empruntDao = EmpruntDaoI.getInstance();
        int count = -1;
        try {
           count = empruntDao.getListCurrentByMembre(membre.getId()).size();
           return count < membre.getAbonnement().getVal();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
        }
        
        return false;
    }
}