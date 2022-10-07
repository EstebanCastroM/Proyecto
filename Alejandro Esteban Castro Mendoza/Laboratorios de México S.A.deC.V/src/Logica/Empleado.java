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
public class Empleado{
    public String nombre;
    public int edad;
    public String rfc;
    public String codigo;
    public String tipo;
    public double salario;
    
    public String nombreProc;
    public String tipoProc;
    public String codigoProc;
    public int existenciaProc;
    public String codigoMod;

    public String getCodigoMod() {
        return codigoMod;
    }

    public void setCodigoMod(String codigoMod) {
        this.codigoMod = codigoMod;
    }

    public String getNombreProc() {
        return nombreProc;
    }

    public void setNombreProc(String nombreProc) {
        this.nombreProc = nombreProc;
    }

    public String getTipoProc() {
        return tipoProc;
    }

    public void setTipoProc(String tipoProc) {
        this.tipoProc = tipoProc;
    }

    public String getCodigoProc() {
        return codigoProc;
    }

    public void setCodigoProc(String codigoProc) {
        this.codigoProc = codigoProc;
    }

    public int getExistenciaProc() {
        return existenciaProc;
    }

    public void setExistenciaProc(int existenciaProc) {
        this.existenciaProc = existenciaProc;
    }

    public double getPrecioProc() {
        return precioProc;
    }

    public void setPrecioProc(double precioProc) {
        this.precioProc = precioProc;
    }
    public double precioProc;
    

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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
        public String mostrar_info() {
       
       String info= "Nombre :" + getNombre() + "\n" +
                    "Edad :" + getEdad() + "\n" +
                    "RFC:" + getRfc() + "\n" +
                    "Codigo :" + getCodigo() + "\n" +
                    "Tipo :"+ getTipo() + "\n" +
                    "Salario :"+ getSalario() + "\n";
       
       return info;
    }
}
