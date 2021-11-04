/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.entity;

/**
 *
 * @author Carlos
 */
public class Empleado {
    //codigo:int
    //nombres:String
    //sueldo:double

    private int codigo;
    private String nombres;
    private double sueldo;

    public Empleado() {
        this.codigo = -1;
        this.nombres = "DANIEL";
        this.sueldo = 930.00;
    }

    public Empleado(int codigo, String nombres, double sueldo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.sueldo = sueldo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


}
