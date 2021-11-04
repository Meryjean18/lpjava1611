/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao.mysql;
import java.sql.Connection;
import com.edu.sise.capas.dao.Conexion;
import com.edu.sise.capas.dao.IDAOManager;
import com.edu.sise.capas.dao.IEmpleadoDAO;


/**
 *
 * @author meryj
 */
public class MysqlDAOManager implements IDAOManager{
    
    //SINGLETON - parte 1
    private static final MysqlDAOManager instancia = new MysqlDAOManager();
    private Connection cn; 
    
    private MysqlDAOManager(){
        cn = new Conexion().getConn();        
    }                   
   
    //singelton - parte 2
    public static MysqlDAOManager getInstancia(){
        return instancia;
    }
    //Factory 
    private IEmpleadoDAO empleadoDao = null;    
      
    @Override
    public IEmpleadoDAO getEmpleadoDAO() {
        if(empleadoDao==null){
            empleadoDao = new MysqlEmpleadoDAO(cn);
        }
        return empleadoDao;
    }
    
    
}
