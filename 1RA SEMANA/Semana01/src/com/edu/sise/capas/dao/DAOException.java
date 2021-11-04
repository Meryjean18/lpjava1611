/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao;

/**
 *
 * @author meryj
 */
public class DAOException extends Exception{

    public DAOException(String string) {
        super(string);
    }

    public DAOException(String string, Throwable throwbl) {
        super(string, throwbl);
    }

    public DAOException(Throwable throwbl) {
        super(throwbl);
    }

    
    
    
    
}
