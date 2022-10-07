/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import Logica.Cliente;
/**
 *
 * @author EAV
 */
public class Basedatoscliente {
    
    Connection conexion;
    PreparedStatement stInsertar;
    PreparedStatement stConsultar;
    PreparedStatement stConsultars;
    PreparedStatement stActualizar;
    PreparedStatement stEliminar;
        
    public Basedatoscliente(){
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
        stInsertar = conexion.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?)");
        stConsultar = conexion.prepareStatement("SELECT * FROM cliente WHERE codigo=?");
        stConsultars = conexion.prepareStatement("SELECT * FROM cliente WHERE nombre=?");
        stActualizar = conexion.prepareStatement("UPDATE cliente set nombre=?, edad=?, domicilio=?, codigo=? WHERE codigo=?");
        stEliminar = conexion.prepareStatement("DELETE FROM cliente WHERE codigo=?");
        }catch(SQLException ex){
         System.out.println("Error al obtener la conexion");
         System.out.println(ex.getMessage());
        }
    }
            public Cliente consultarRegistro(String codigo){
        Cliente objCli=null;
        ResultSet rs=null;
        try{
        stConsultar.setString(1, codigo);
        rs=stConsultar.executeQuery();
        if(rs.next()){
            objCli=new Cliente();
            objCli.setNombre(rs.getString("nombre"));
            objCli.setEdad(rs.getInt("Edad"));
            objCli.setDomicilio(rs.getString("Domicilio"));
            objCli.setCodigo(rs.getString("Codigo"));
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objCli;
        }
                        
        public Cliente consultarRegistron(String nombre){
        Cliente objCli=null;
        ResultSet rs=null;
        try{
        stConsultars.setString(1, nombre);
        rs=stConsultars.executeQuery();
        if(rs.next()){
            objCli=new Cliente();
            objCli.setNombre(rs.getString("nombre"));
            objCli.setEdad(rs.getInt("edad"));
            objCli.setDomicilio(rs.getString("domicilio"));
            objCli.setCodigo(rs.getString("codigo"));
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objCli;
    }
        
            public void actualizarRegistro(Cliente objCli){
        try{
        
        stActualizar.setString(1, objCli.getNombre());
        stActualizar.setInt(2, objCli.getEdad());
        stActualizar.setString(3, objCli.getDomicilio());
         stActualizar.setString(4, objCli.getCodigo());       
        stActualizar.setString(5, objCli.getCodigoMod());
        stActualizar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al Actualizar un registro");
            System.out.println(ex.getMessage());
        }
        
        
    }
             
        public void insertarRegistro(Cliente objClis){
        try{
        stInsertar.setString(1, objClis.getNombre());
        stInsertar.setInt(2, objClis.getEdad());
        stInsertar.setString(3, objClis.getDomicilio());
        stInsertar.setString(4, objClis.getCodigo());;
        stInsertar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar un registro");
            System.out.println(ex.getMessage());
        }
    }
            public void eliminarRegistro(Cliente objCli){
        try{
            stEliminar.setString(1, objCli.getCodigo());
            stEliminar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al eliminar un registro");
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

    
}
