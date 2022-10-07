/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author EAV
 */
public class Cliente {
    public String nombre;
    public int edad;
    public String domicilio;
    public String codigo;
    public String codigoMod;

    public String getCodigoMod() {
        return codigoMod;
    }

    public void setCodigoMod(String codigoMod) {
        this.codigoMod = codigoMod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    
            public String mostrar_info() {
       
       String info= "Nombre :" + getNombre() + "\n" +
                    "Edad :" + getEdad() + "\n" +
                    "Domicilio :" +getDomicilio() + "\n"+
                    "Codigo :" + getCodigo() + "\n";
       
       return info;
    }
    
    
}
