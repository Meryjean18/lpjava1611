/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.logic;

import com.edu.sise.capas.dao.EmpleadoDao;
import com.edu.sise.capas.entity.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class EmpleadoLogic {
    
    private EmpleadoDao dao;
    
    public EmpleadoLogic(){
        dao = new EmpleadoDao();
    }
    
    public DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("SUELDO");
        
        List<Empleado> listaEmpleados = dao.obtenerEmpleados();
        
        for(int i=0;i<listaEmpleados.size();i++){
            Object data[] = {
                listaEmpleados.get(i).getCodigo(),
                listaEmpleados.get(i).getNombres(),
                listaEmpleados.get(i).getSueldo()
            };
            modelo.addRow(data);
        } 
        return modelo;
    }
    
}
