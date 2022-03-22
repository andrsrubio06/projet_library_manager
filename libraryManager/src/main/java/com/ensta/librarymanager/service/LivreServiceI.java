package com.ensta.librarymanager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ensta.librarymanager.dao.LivreDao;
import com.ensta.librarymanager.dao.LivreDaoI;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Livre;

public class LivreServiceI implements LivreService {
    private static LivreServiceI instance;

    private LivreServiceI() {}

    
    /** 
     * @return LivreService
     */
    public static LivreServiceI getInstance() {
        if(instance == null) {
            instance = new LivreServiceI();
        }
        return instance;
    } 

    
    /** 
     * @return List<Livre>
     * @throws ServiceException
     */
    @Override
    public List<Livre> getList() throws ServiceException {
        LivreDao livreDao = LivreDaoI.getInstance();
        List<Livre> livres = new ArrayList<>();
        try {
            livres = livreDao.getList();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return livres;
    }

    
    /** 
     * @return List<Livre>
     * @throws ServiceException
     */
    @Override
	public List<Livre> getListDispo() throws ServiceException {
        EmpruntService empruntService = EmpruntServiceI.getInstance();
        List<Livre> livres = getList();
        
        Iterator<Livre> iter = livres.iterator();
        while (iter.hasNext()) {
            Livre livre = iter.next(); 
            if(!empruntService.isLivreDispo(livre.getId())) {
                iter.remove();
            }
        }
        return livres;
    }

    
    /** 
     * @param id
     * @return Livre
     * @throws ServiceException
     */
    @Override
	public Livre getById(int id) throws ServiceException {
        LivreDao livreDao = LivreDaoI.getInstance();
        Livre livre = new Livre();
        try {
            livre = livreDao.getById(id);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return livre;
    }

    
    /** 
     * @param titre
     * @param auteur
     * @param isbn
     * @return int
     * @throws ServiceException
     */
    @Override
	public int create(String titre, String auteur, String isbn) throws ServiceException {
        LivreDao livreDao = LivreDaoI.getInstance();
        int i = -1;
        
        if(titre == null || titre.isBlank()) {
			throw new ServiceException("Problème lors de la création du livre: Le titre ne peut pas être vide");
        }

        try {
            i = livreDao.create(titre, auteur, isbn);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return i;
    }

    
    /** 
     * @param livre
     * @throws ServiceException
     */
    @Override
	public void update(Livre livre) throws ServiceException {
        LivreDao livreDao = LivreDaoI.getInstance();
        
        if(livre.getTitre() == null || livre.getTitre().isBlank()) {
			throw new ServiceException("Problème lors de la mis à jour du livre: Le titre ne peut pas être vide");
        }

        try {
            livreDao.update(livre);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
    }

    
    /** 
     * @param id
     * @throws ServiceException
     */
    @Override
	public void delete(int id) throws ServiceException {
        LivreDao livreDao = LivreDaoI.getInstance();
        try {
            livreDao.delete(id);
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
        LivreDao livreDao = LivreDaoI.getInstance();
        int count = -1;
        try {
            count = livreDao.count();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
        }
        return count;
    }
}