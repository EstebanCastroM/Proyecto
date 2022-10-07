/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author EAV
 */
import java.sql.*;
import Logica.Empleado;

public class Basedatosempleado {
    
    Connection conexion;
    PreparedStatement stInsertar;
    PreparedStatement stConsultar;
    PreparedStatement stActualizar;
    PreparedStatement stEliminar;
    PreparedStatement stInsertars;
    
    
    public Basedatosempleado(){
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
        stInsertar = conexion.prepareStatement("INSERT INTO empleado VALUES(?,?,?,?,?,?)");
        stInsertars = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
        stConsultar = conexion.prepareStatement("SELECT * FROM empleado WHERE codigo=?");
        stActualizar = conexion.prepareStatement("UPDATE empleado set nombre=?, edad=?, rfc=?, codigo=?, tipo=?, salario=? WHERE codigo=?");
        stEliminar = conexion.prepareStatement("DELETE FROM empleado WHERE codigo=?");
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
        public void insertarRegistro(Empleado objEmp){
        try{
        stInsertar.setString(1, objEmp.getNombre());
        stInsertar.setInt(2, objEmp.getEdad());
        stInsertar.setString(3, objEmp.getRfc());
        stInsertar.setString(4, objEmp.getCodigo());
        stInsertar.setString(5, objEmp.getTipo());
        stInsertar.setDouble(6, objEmp.getSalario());
        stInsertar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar un registro");
            System.out.println(ex.getMessage());
        }
    }
            public void insertarRegistros(Empleado objEmp){
        try{
        stInsertars.setString(1, objEmp.getNombreProc());
        stInsertars.setString(2, objEmp.getTipoProc());
        stInsertars.setString(3, objEmp.getCodigoProc());
        stInsertars.setInt(4, objEmp.getExistenciaProc());
        stInsertars.setDouble(5, objEmp.getPrecioProc());
        stInsertars.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar un registro");
            System.out.println(ex.getMessage());
        }
    }
            public void eliminarRegistro(Empleado objEmp){
        try{
            stEliminar.setString(1, objEmp.getCodigo());
            stEliminar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al eliminar un registro");
            System.out.println(ex.getMessage());
        }
    }
            public Empleado consultarRegistro(String codigo){
        Empleado objEmp=null;
        ResultSet rs=null;
        try{
        stConsultar.setString(1, codigo);
        rs=stConsultar.executeQuery();
        if(rs.next()){
            objEmp=new Empleado();
            objEmp.setNombre(rs.getString("nombre"));
            objEmp.setEdad(rs.getInt("Edad"));
            objEmp.setRfc(rs.getString("RFC"));
            objEmp.setCodigo(rs.getString("Codigo"));
            objEmp.setTipo(rs.getString("Tipo"));
            objEmp.setSalario(rs.getDouble("Salario"));
        }
        }catch(SQLException ex){
            System.out.println("Error al consultar un registro");
            System.out.println(ex.getMessage());
        }
        return objEmp;
    }
                public void actualizarRegistro(Empleado objEmp){
        try{
        
        stActualizar.setString(1, objEmp.getNombre());
        stActualizar.setInt(2, objEmp.getEdad());
        stActualizar.setString(3, objEmp.getRfc());
         stActualizar.setString(4, objEmp.getCodigo());       
        stActualizar.setString(5, objEmp.getTipo());
        stActualizar.setDouble(6, objEmp.getSalario());
        stActualizar.setString(7, objEmp.getCodigoMod());
        stActualizar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al Actualizar un registro");
            System.out.println(ex.getMessage());
        }
        
        
    }

    
    
}
