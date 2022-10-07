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
public class Producto {
    
    private String codigo;
    private String tipo;
    private String nombre;
    private int existencia;
    private double precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
        

    public String mostrar_info() {
       
       String info= "Nombre :" + getNombre() + "\n" +
                    "Tipo :" + getTipo() + "\n" +
                    "Codigo:" + getCodigo() + "\n" +
                    "Existencia :" + getExistencia() + "\n" +
                    "Precio :"+ getPrecio() + "\n";
       
       return info;
    }
    
}
