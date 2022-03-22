package com.ensta.librarymanager.utils;


public enum Abonnement {
    BASIC(2),
    PREMIUM(5),
    VIP(20);
 
    private int val;
    
    private Abonnement(int val)
    {
        this.val = val;
    }

    public int getVal () {
        return this.val;
    }
}
