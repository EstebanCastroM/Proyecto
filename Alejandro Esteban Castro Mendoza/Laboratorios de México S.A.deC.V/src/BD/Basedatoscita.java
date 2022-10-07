/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import Logica.Cita;
/**
 *
 * @author EAV
 */
public class Basedatoscita {
    
    Connection conexion;
    PreparedStatement stInsertar;
    PreparedStatement stConsultar;
    
        public Basedatoscita(){
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
        stInsertar = conexion.prepareStatement("INSERT INTO cita VALUES(?,?,?,?,?)");
        stConsultar = conexion.prepareStatement("SELECT * FROM cita WHERE codigo=?");
        }catch(SQLException ex){
         System.out.println("Error al obtener la conexion");
         System.out.println(ex.getMessage());
        }
    }
            public Cita consultarRegistro(String codigo){
        Cita objCit=null;
        ResultSet rs=null;
        try{
        stConsultar.setString(1, codigo);
        rs=stConsultar.executeQuery();
        if(rs.next()){
            objCit=new Cita();
            objCit.setCodigo12(rs.getString("codigo"));
            objCit.setHora(rs.getString("hora"));
            objCit.setDia(rs.getString("dia"));
            objCit.setMes(rs.getString("mes"));
            objCit.setTipo(rs.getString("tipo"));
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objCit;
        }
            public void insertarRegistro(Cita objCits){
        try{
        stInsertar.setString(1, objCits.getCodigo12());
        stInsertar.setString(2, objCits.getHora());
        stInsertar.setString(3, objCits.getDia());
        stInsertar.setString(4, objCits.getMes());
        stInsertar.setString(5, objCits.getTipo());
        stInsertar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar un registro");
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
