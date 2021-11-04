/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.capas.logic;


import com.edu.sise.capas.dao.IEmpleadoDAO;
import com.edu.sise.capas.dao.mysql.MysqlDAOManager;
import com.edu.sise.capas.entity.Empleado;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream; 
import java.io.InputStreamReader;
import java.time.LocalDate;

/**
 *
 * @author meryj
 */
public class EmpleadoLogic {
    
    MysqlDAOManager factory = MysqlDAOManager.getInstancia(); //singleton
    IEmpleadoDAO dao = factory.getEmpleadoDAO();
    
    private DefaultTableModel obtenerTodos() throws Exception{
        DefaultTableModel modelo = getmodelo();
        List<Empleado> lista = dao.obtenerTodos();
        for(Empleado obj : lista){        
            Object data[] = {
                obj.getId_empleado(),
                obj.getApe_pat(),
                obj.getApe_mat(),
                obj.getFnacimiento(),
                obj.getSueldo()
            };
            modelo.addRow(data);            
        }
        return modelo;      
        
    }
    
    public DefaultTableModel obtenerBusqueda() throws Exception{
    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APE. PAT.");
        modelo.addColumn("APE. MAT.");
        modelo.addColumn("FEC. NAC.");
        modelo.addColumn("SUELDO");
        List<Empleado> lista = dao.obtenerBusqueda(v1);
        for (Empleado obj : lista){
            Object data[] = {
                obj.getId_empleado(),
                obj.getApe_pat(),
                obj.getApe_mat(),
                obj.getFnacimiento(),
                obj.getSueldo()
            };
            modelo.addRow(data);            
        }
        return modelo; 
    
    }
    
    public void imprimirTB(JTable jTable) throws Exception{
        jTable.setModel(obtenerTodos());
    }
    
    public void imprimirTB(JTable jTable, DefaultTableModel modelo) throws Exception{
        jTable.setModel(modelo);
    }
    
    public void insertar(Empleado o ) throws Exception{
        dao.insertar(o);        
    }
    
    public void modificar(Empleado o ) throws Exception{
        dao.modificar(o);
    }
        
    public void eliminar(Empleado o ) throws Exception{
        dao.eliminar(o);
    } 
    
    private DefaultTableModel getModelo(){
     DefaultTableModel modelo = new DefaultTableModel();
     modelo.addColumn("ID");
     
    }
    
    public int cargaMasiva (String rutaArchivo)throws Exception{
        FileInputStream archivo = new FileInputStream(rutaArchivo);
        DataInputStream entrada = new DataInputStream(archivo);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
        List<Empleado> lista = new ArrayList<>();
        String linea;
        while((linea=buffer.readLine())!=null){
            System.out.println(linea);
            String[] campos = linea.split("\\|");
            lista.add(new Empleado(
                    0,
                    campos[0],
                    campos[1],
                    campos[2],
                    LocalDate.parse(campos[3]),
                    Double.parseDouble(campos[4])             
            ));                 
                    
        }
        entrada.close();
        
        int[] resultados = dao.cargaMasiva(lista);
        //resul
        int registros_afectados=0;
        for(int i= 0; i<resultados.length;i++){
            registros_afectados = registros_afectados + resultados[i];
            
        }
        
        return 0;
        
        
    }
            
    
    
    
}
