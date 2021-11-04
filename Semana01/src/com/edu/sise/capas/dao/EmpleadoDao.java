/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao;

import com.edu.sise.capas.entity.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class EmpleadoDao {
    
    public List obtenerEmpleados(){
        //ArrayList
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();
        Empleado objEmpleado = new Empleado();
        objEmpleado.setCodigo(1007);
        objEmpleado.setNombres("Carlos");
        objEmpleado.setSueldo(6000);
        
        listaEmpleados.add(new Empleado(1001, "Cesar", 5000));
        listaEmpleados.add(new Empleado(1002, "Enzo", 4500));
        listaEmpleados.add(new Empleado(1003, "Fernando", 3500));
        listaEmpleados.add(new Empleado(1004, "Gian", 6500));
        listaEmpleados.add(new Empleado(1005, "Jackson", 5500));
        listaEmpleados.add(objEmpleado);
        
        return listaEmpleados;
    }
}
