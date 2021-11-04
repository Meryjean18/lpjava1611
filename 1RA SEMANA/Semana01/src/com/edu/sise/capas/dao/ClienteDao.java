/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao;

import com.edu.sise.capas.entity.Cliente;
import com.edu.sise.capas.entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author meryj
 */
public class ClienteDao {
    
    Connection cn = null;
    
    public Usuario obtenerUsuarioxID(int id){
        cn = new Conexion().getConn();
        
        String sql = "select * from usuarios where id_usuario = "+id;
        Usuario objUsuario = null;
        
        try {
            Statement st = cn.createStatement ();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                objUsuario = new Usuario();
                objUsuario.setId_usuario(rs.getInt("id_usuario"));
                objUsuario.setNombre(rs.getString("nombre"));
                objUsuario.setClave(rs.getString("clave"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en Statement: " + ex);
            
        }finally{
            if (cn!=null){
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion: " + ex);  
                }
            }
        }
        
        return objUsuario;        
    }  
    
    public Usuario validarAcceso(Usuario objUsuario){
        cn = new Conexion().getConn();
        String sql = "select * from usuarios "
                + " where nombre='"+objUsuario.getNombre()
                +"' and clave='"+ objUsuario.getClave()+"'";
        
        Usuario rptaUsuario = null;
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                rptaUsuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("clave")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error en Statement: " + ex);
        }finally{
            if(cn!=null){
                try {    
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion: " + ex); 
                   
                }
            
            }
        }
        return rptaUsuario;
    }
    
    public List obtenerTodos(){
        cn = new Conexion().getConn();
        String sql = "select * from usuarios";
        
        List ListaUsuarios = new ArrayList<Usuario>();
        Usuario objUsuario = null;
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                objUsuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("clave")
                );
                ListaUsuarios.add(objUsuario);
                
            
            }
        } catch (SQLException ex) {
            System.out.println("Error en Statement: " + ex);            
        }finally{
            if(cn!=null){
                try {    
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion: " + ex); 
                   
                }
            
            }
        }
        return ListaUsuarios;        
    }      

    public Cliente obtenerClientexID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente validarAcceso(Cliente objcliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
