package com.ensta.librarymanager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ensta.librarymanager.dao.MembreDao;
import com.ensta.librarymanager.dao.MembreDaoI;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Membre;



public class MembreServiceI implements MembreService {
    private static MembreServiceI instance;

    private MembreServiceI() {}

    
    /** 
     * @return MembreService
     */
    public static MembreServiceI getInstance() {
        if(instance == null) {
            instance = new MembreServiceI();
        }
        return instance;
    }
    
    
    /** 
     * @return List<Membre>
     * @throws ServiceException
     */
    @Override
    public List<Membre> getList() throws ServiceException {
        MembreDao membreDao = MembreDaoI.getInstance();
        List<Membre> membres = new ArrayList<>();
        try {
            membres = membreDao.getList();
        } catch (DaoException e) {
			System.out.println(e.getMessage());
		}
        return membres;
    }

    
    /** 
     * @return List<Membre>
     * @throws ServiceException
     */
    @Override
	public List<Membre> getListMembreEmpruntPossible() throws ServiceException {
        EmpruntService empruntService = EmpruntServiceI.getInstance();
        List<Membre> membres = getList();

        Iterator<Membre> iter = membres.iterator();
        while (iter.hasNext()) {
            Membre membre = iter.next(); 
            if(!empruntService.isEmpruntPossible(membre)) {
                iter.remove();
            }
        }
        return membres;
    }

    
    /** 
     * @param id
     * @return Membre
     * @throws ServiceException
     */
    @Override
	public Membre getById(int id) throws ServiceException {
        MembreDao membreDao = MembreDaoI.getInstance();
        Membre membre = new Membre();
        try {
            membre = membreDao.getById(id);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return membre;
    }

    
    /** 
     * @param nom
     * @param prenom
     * @param adresse
     * @param email
     * @param telephone
     * @return int
     * @throws ServiceException
     */
    @Override
	public int create(String nom, String prenom, String adresse, String email, String telephone) throws ServiceException {
        MembreDao membreDao = MembreDaoI.getInstance();
        int i = -1;
        
        if(nom == null || nom.isBlank() || prenom == null || prenom.isBlank()) {
			throw new ServiceException("Problème lors de la création du membre: Le nom ou le prénom ne peut pas être vide");
        }

        try {
            i = membreDao.create(nom.toUpperCase(), prenom, adresse, email, telephone);
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
		}
        return i;
    }

    
    /** 
     * @param membre
     * @throws ServiceException
     */
    @Override
	public void update(Membre membre) throws ServiceException {
        MembreDao membreDao = MembreDaoI.getInstance();
        
        if(membre.getNom() == null ||  membre.getNom().isBlank() || membre.getPrenom() == null || membre.getPrenom().isBlank()) {
            throw new ServiceException("Problème lors de la mis à jour du membre: Le nom ou le prénom ne peut pas être vide");
        }

        try {
            membre.setNom(membre.getNom().toUpperCase());
            membreDao.update(membre);
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
        MembreDao membreDao = MembreDaoI.getInstance();
        try {
            membreDao.delete(id);
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
        MembreDao membreDao = MembreDaoI.getInstance();
        int count = -1;
        try {
            count = membreDao.count();
        } catch (DaoException e) {
			System.out.println(e.getMessage());			
        }
        return count;
    }
    
}