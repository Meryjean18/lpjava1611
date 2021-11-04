/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.logic;

import com.edu.sise.capas.dao.ClienteDao;
import com.edu.sise.capas.entity.Cliente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meryj
 */
public class ClienteLogic {
    
    ClienteDao dao = null;
    
    public Cliente obtenerclientexID(int id){   
        Cliente objcliente = null;
        dao = new  ClienteDao();
        
        if (id>=0){
            objcliente = dao.obtenerClientexID(id);
        }
        return objcliente;
        
    }
    
    public Cliente validarAcceso(Cliente objcliente){
        dao = new ClienteDao();
        return dao.validarAcceso(objcliente);
    }
    
    public DefaultTableModel obtenerTodos(){
        dao = new ClienteDao();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CLAVE");
        
        List<Cliente> listacliente = dao.obtenerTodos();
        Cliente objcliente = null;
        
        for(int i=0; i<listacliente.size();i++){
            objcliente = listacliente.get(i);
            
            Object data[] ={
                objcliente.getId_cliente(),
                objcliente.getNombre(),
                objcliente.getClave()                
            };                       
            modelo.addRow(data);
        }
        return modelo;        
    }
    
    public void imprimirTB(JTable jTable){
        jTable.setModel(obtenerTodos());
        
    }
    
}
