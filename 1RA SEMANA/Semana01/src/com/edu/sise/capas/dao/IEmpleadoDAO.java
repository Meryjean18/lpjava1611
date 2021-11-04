/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao;

import com.edu.sise.capas.entity.Empleado;

/**
 *
 * @author meryj
 */
public interface IEmpleadoDAO extends GenericDAO<Empleado, Integer>{
    double calcularBonificacion() throws DAOException;
    
    List<Empleado> obtenerBusqueda(String v1) throws DAOException;
    int [] cargaMasiva   (List<Empleado>lista);
}
