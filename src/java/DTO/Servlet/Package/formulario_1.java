/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Servlet.Package;

import java.text.DecimalFormat;

/**
 *
 * @author wezarkeVo
 */
public class formulario_1 {
    
    private String nombre;
    private int cuotas;
    private double cuotaInicial;
    private String tipoInmueble;
    
    public double castInt;
    public double saldoActual;
    public double valorXCuota;
    public double iteracionDescuento;
    public String Format_2;
    
   public double getCastInt(){
       this.castInt = Double.parseDouble(this.tipoInmueble);
       return castInt;
   } 
    
    
   public double getSaldoActual(double castInt){
       this.saldoActual = castInt - this.cuotaInicial;
       return saldoActual;
   } 
    
   public double getValorXCuota(double saldoActual){
     this.valorXCuota = saldoActual/this.cuotas;
     return valorXCuota;
   }
    
   public double getIteracionDescuento(double saldoActual){
       this.iteracionDescuento = saldoActual;
       return iteracionDescuento;
   }
   
    public formulario_1(String nombre, int cuotas, double cuotaInicial, String tipoInmueble) {
        this.nombre = nombre;
        this.cuotas = cuotas;
        this.cuotaInicial = cuotaInicial;
        this.tipoInmueble = tipoInmueble;
        
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuotas() {
        return cuotas;
    }

    public double getCuotaInicial() {
        return cuotaInicial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public void setCuotaInicial(double cuotaInicial) {
        this.cuotaInicial = cuotaInicial;
    }
    
    
    
    
    
    
    
}
