/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.logic;

import com.edu.sise.capas.dao.UsuarioDao;
import com.edu.sise.capas.entity.Usuario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class UsuarioLogic {
    
    UsuarioDao dao =  null;
    
    public Usuario obtenerUsuarioxID(int id){
        Usuario objUsuario = null;
        dao = new UsuarioDao();
        if(id>=0){
            objUsuario = dao.obtenerUsuarioxID(id);
        }
        return objUsuario;
    }
    
    public Usuario validarAcceso(Usuario objUsuario){
        dao = new UsuarioDao();
        return dao.validarAcceso(objUsuario);
    }
    
    public DefaultTableModel obtenerTodos(){
        dao = new UsuarioDao();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CLAVE");
        
        List<Usuario> listaUsuario = dao.obtenerTodos();
        Usuario objUsuario =  null;
        
        for(int i=0; i<listaUsuario.size();i++){
            objUsuario = listaUsuario.get(i);
            
            Object data[] = {
                objUsuario.getId_usuario(),
                objUsuario.getNombre(),
                objUsuario.getClave()
            };
            
            modelo.addRow(data);
        }
        
        return modelo;
    }
    
    public void imprimirTB(JTable jTable){
        jTable.setModel(obtenerTodos());
    }
    
}
