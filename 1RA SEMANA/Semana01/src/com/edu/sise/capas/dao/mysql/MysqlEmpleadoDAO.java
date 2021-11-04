/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.dao.mysql;

import com.edu.sise.capas.dao.DAOException;
import com.edu.sise.capas.dao.IEmpleadoDAO;
import com.edu.sise.capas.entity.Empleado;
import java.sql.Connection;

import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author meryj
 */
public class MysqlEmpleadoDAO implements IEmpleadoDAO{
    
    final String INSERT = "INSERT INTO empleados(nombre, ape_pat, ape_mat,fnacimiento, sueldo)"
            + " VALUES(?,?,?,?,?)";
    final String GETALL = "SELECT * FROM empleados";
    final String UPDATE = "UPDATE empleados"
            +" SET nombre = ?, ape_pat = ?, ape_mat = ?, fnacimiento = ?, sueldo = ?"
            +"WHERE id_empleado = ?";            
    final String BUSQUEDA ="SELECT * FROM empleados"
            +"WHERE nombre LIKE ? || ape_pat LIKE ? || ape_mat LIKE ? ";
    
    private Connection cn;
    
    public MysqlEmpleadoDAO(Connection cn){
        this.cn = cn;
    }

    @Override
    public double calcularBonificacion() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Empleado o) throws DAOException {
        PreparedStatement ps =null;
        ResultSet rs = null;
        try{
            ps = cn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            int i= 1;
            ps.setString(i++, o.getNombre());
            ps.setString(i++, o.getApe_pat());
            ps.setString(i++, o.getApe_mat());
            ps.setDate(i++, Date.valueOf(o.getFnacimiento()));
            ps.setDouble(i++, o.getSueldo());
            
            if (ps.executeUpdate()==0)
                throw new DAOException("No se pudo realizar el registro!!!");
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                
            }else{
                throw new DAOException("No se puede generar el ID del empleado");
                
            }
        }catch(SQLException ex){
            
        }
    }

    @Override
    public void modificar(Empleado o) throws DAOException {
        PreparedStatement ps =null;
        
        try{
            ps = cn.prepareStatement(UPDATE);
            int i= 1;
            ps.setString(i++, o.getNombre());
            ps.setString(i++, o.getApe_pat());
            ps.setString(i++, o.getApe_mat());
            ps.setDate(i++, Date.valueOf(o.getFnacimiento()));
            ps.setDouble(i++, o.getSueldo());
            
            if (ps.executeUpdate()==0)
                throw new DAOException("No se pudo modificar el registro!!!");
            
            
        }catch(SQLException ex){
            
            
        }
    }

    @Override
    public void eliminar(Empleado o) throws DAOException {
                                                                                                                                                                                                                                
        
    }

    @Override
    public List<Empleado> obtenerTodos() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Empleado> lista = new ArrayList<>();
        try{
            ps = cn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));               
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);        
        }finally{
            try {
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();               
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL ", ex);  
            } 
        }
        return lista;
    }

    @Override
    public Empleado obtenerxID(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Empleado getRS(ResultSet rs) throws SQLException{
        return new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("nombre"),
                rs.getString("ape_pat"),
                rs.getString("ape_mat"),
                rs.getDate("fnacimiento").toLocalDate(),
                rs.getDouble("sueldo")                
        
        );
    }

    @Override
    public Object obtenerBusqueda(String v1) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Empleado> lista = new ArrayList<>();
        String valor ="%"+v1+"%";
        try{
            ps = cn.prepareStatement(BUSQUEDA);
            int i=1;
            ps.setString(i++, valor);
            ps.setString(i++, valor);
            ps.setString(i++, valor);                       
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));               
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);        
        }finally{
            try {
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();               
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL ", ex);  
            } 
        }
        return lista;
        
    }

    @Override
    public int[] cargaMasiva(List<Empleado>lista) {
        PreparedStatement ps = null;
        int[] res;
        try{
            ps=cn.prepareStatement(INSERT);
            for(Empleado o: lista){
                int i=1;
                ps.setString(i++,o.getNombre());
                ps.setString(i++,o.getApe_pat());
                ps.setString(i++,o.getApe_mat());
                ps.setDate(i++,Date.valueOf(o.getFnacimiento()));
                ps.setDouble(i++,o.getSueldo());
                ps.addBatch();
            }
            res = ps.executeBatch();
            if(res.length==0)
                throw new DAOException("No se pudo realizar la carga masiva!!!");           
            } catch(SQLException){
                throw new DAOException("Error en SQL", ex);
            }finally{
                try{
                   if(ps!=null) ps.close(); 
                }catch(SQLException){
                    throw new DAOException("Error en SQL", ex);
                }
            
            } 
            return res;        
        
    }
}
