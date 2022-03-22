package com.ensta.librarymanager.model;


public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String isbn;

    public Livre() {
        super();
    }

    public Livre(int id, String titre, String auteur, String isbn) {
        this();
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    
    /** 
     * Return the book id
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * Set the book id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * Return the book title
     * @return String
     */
    public String getTitre() {
        return this.titre;
    }

    
    /**
     * Set the book title 
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    
    /** 
     * Return the book author
     * @return String
     */
    public String getAuteur() {
        return this.auteur;
    }

    
    /** 
     * Set the book author
     * @param auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    
    /** 
     * Return the book ISBN
     * @return String
     */
    public String getIsbn() {
        return this.isbn;
    }

    
    /** 
     * Set the book ISBN
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    /** 
     * Returns a string representation of the book
     * @return String
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() +
            " id='" + id + "'" +
            ", titre='" + titre + "'" +
            ", auteur='" + auteur + "'" +
            ", isbn='" + isbn + "'";
    }

}