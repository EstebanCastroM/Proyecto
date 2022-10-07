/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import Logica.Producto;

/**
 *
 * @author EAV
 */
public class Basedatos {
    
    Connection conexion;
    PreparedStatement stInsertar;
    PreparedStatement stConsultar;
    PreparedStatement stConsultars;
    PreparedStatement stActualizar;
    PreparedStatement stEliminar;
    public Basedatos(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
         System.out.println("Error al cargar el controlador");
         System.out.println(ex.getMessage());
            
        }
    }
    public void abrir(){
        try{
        conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/laboratorio?serverTimezone=GMT-5", "root", "");
        stInsertar = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
        stConsultar = conexion.prepareStatement("SELECT * FROM producto WHERE codigo=?");
        stConsultars = conexion.prepareStatement("SELECT * FROM producto WHERE nombre=?");
        stActualizar = conexion.prepareStatement("UPDATE producto set precio=? WHERE codigo=?");
        }catch(SQLException ex){
         System.out.println("Error al obtener la conexion");
         System.out.println(ex.getMessage());
        }
    }
        
    public void cerrar(){
        try{
        conexion.close();
        }catch(SQLException ex){
         System.out.println("Error al cerrar la conexion");
         System.out.println(ex.getMessage());
        }
    }
    public void insertarRegistro(Producto objPro){
        try{
        stInsertar.setString(1, objPro.getNombre());
        stInsertar.setString(2, objPro.getTipo());
        stInsertar.setString(3, objPro.getCodigo());
        stInsertar.setInt(4, objPro.getExistencia());
        stInsertar.setDouble(5, objPro.getPrecio());
        stInsertar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar un registro");
            System.out.println(ex.getMessage());
        }
    }
        public Producto consultarRegistro(String codigo){
        Producto objPro=null;
        ResultSet rs=null;
        try{
        stConsultar.setString(1, codigo);
        rs=stConsultar.executeQuery();
        if(rs.next()){
            objPro=new Producto();
            objPro.setNombre(rs.getString("nombre"));
            objPro.setTipo(rs.getString("tipo"));
            objPro.setCodigo(rs.getString("codigo"));
            objPro.setExistencia(rs.getInt("existencia"));
            objPro.setPrecio(rs.getDouble("precio"));
;
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objPro;
    }
                public Producto consultarRegistron(String nombre){
        Producto objPro=null;
        ResultSet rs=null;
        try{
        stConsultars.setString(1, nombre);
        rs=stConsultars.executeQuery();
        if(rs.next()){
            objPro=new Producto();
            objPro.setNombre(rs.getString("nombre"));
            objPro.setTipo(rs.getString("tipo"));
            objPro.setCodigo(rs.getString("codigo"));
            objPro.setExistencia(rs.getInt("existencia"));
            objPro.setPrecio(rs.getDouble("precio"));
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objPro;
    }
    
    public void actualizarRegistro(Producto objPro){
        try{
        stActualizar.setDouble(1, objPro.getPrecio());
        stActualizar.setString(2, objPro.getCodigo());
        stActualizar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al Actualizar un registro");
            System.out.println(ex.getMessage());
        }
        
        
    }
}
