package com.ensta.librarymanager.model;

import com.ensta.librarymanager.utils.Abonnement;


public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private Abonnement abonnement;

    public Membre() {
        super();
    }

    public Membre(int id, String nom, String prenom, String adresse, String email, String telephone, Abonnement abonnement) {
        this();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.abonnement = abonnement;
    }

    
    /** 
     * Return the member id
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * Set the member id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Return the member lastname
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    
    /** 
     * Set the member lastname
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /** 
     * Return the member name
     * @return String
     */
    public String getPrenom() {
        return this.prenom;
    }

    
    /** 
     * Set the member name
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    /** 
     * Return the member address
     * @return String
     */
    public String getAdresse() {
        return this.adresse;
    }

    
    /** 
     * Set the member address
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    /** 
     * Return the member email
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * Set the member email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * Return the member phone
     * @return String
     */
    public String getTelephone() {
        return this.telephone;
    }

    
    /** 
     * Set the member phone
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    /** 
     * Return the member subscription
     * @return Abonnement
     */
    public Abonnement getAbonnement() {
        return this.abonnement;
    }

    
    /** 
     * Set the member subscription
     * @param abonnement
     */
    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }


    
    /** 
     * * Returns a string representation of the member
     * @return String
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() +
            " id='" + id + "'" +
            ", nom='" + nom + "'" +
            ", prenom='" + prenom + "'" +
            ", adresse='" + adresse + "'" +
            ", email='" + email + "'" +
            ", telephone='" + telephone + "'" +
            ", abonnement='" + abonnement + "'";
    }
    
}