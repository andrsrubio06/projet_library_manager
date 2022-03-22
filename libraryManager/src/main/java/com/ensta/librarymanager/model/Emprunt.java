package com.ensta.librarymanager.model;

import java.time.LocalDate;


public class Emprunt {
    private int id;
    
    private Membre membre;
    private Livre livre;

    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Emprunt() {
        super();
    }
    
    public Emprunt(int id, Membre membre, Livre livre, LocalDate dateEmprunt, LocalDate dateRetour) {
        this();
        this.id = id;
        this.membre = membre;
        this.livre = livre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    
    /** 
     * Return the lending id
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * Set the lending id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Return the lending member
     * @return Membre
     */
    public Membre getMembre() {
        return this.membre;
    }

    
    /** 
     * Set the lending member
     * @param membre
     */
    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    
    /** 
     * Return the lending book
     * @return Livre
     */
    public Livre getLivre() {
        return this.livre;
    }

    
    /** 
     * Set the lending book
     * @param livre
     */
    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    
    /** 
     * Return the lending date  
     * @return LocalDate
     */
    public LocalDate getDateEmprunt() {
        return this.dateEmprunt;
    }

    
    /**
     * Set the lending date  
     * @param dateEmprunt
     */
    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    
    /** 
     * Return the lending return date 
     * @return LocalDate
     */
    public LocalDate getDateRetour() {
        return this.dateRetour;
    }

    
    /** 
     * Set the lending return date 
     * @param dateRetour
     */
    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    /** 
     * Returns a string representation of the lending
     * @return String
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()  +
            " id='" + id + "'" +
            ", membre='" + membre + "'" +
            ", livre='" + livre + "'" +
            ", dateEmprunt='" + dateEmprunt + "'" +
            ", dateRetour='" + dateRetour + "'";
    }

}
