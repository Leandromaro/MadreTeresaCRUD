/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;
/**
 *
 * @author francis
 */
public class ListaIngresos {
    private String mes;
    private String anio;
    private String cuotaSoc="";
    private String donacion="";
    private String floresVida="";
    private String publicidad="";
    private String rifas="";
    private String tarjetas="";

//    public ListaIngresos(String mes, String cuotaSoc, String donacion) {
//        this.mes = mes;
//        this.cuotaSoc = cuotaSoc;
//        this.donacion = donacion;
//       
//    }
//
//    public ListaIngresos(String mes, String floresVida, String publicidad, String rifas, String tarjetas) {
//        this.mes = mes;
//        this.floresVida = floresVida;
//        this.publicidad = publicidad;
//        this.rifas = rifas;
//        this.tarjetas = tarjetas;
//    } 
        
    public ListaIngresos(String mes, String anio, String cuotaSoc, String donacion, String floresVida, String publicidad, String rifas, String tarjetas) {
        this.mes = mes;
        this.anio = anio;
        this.cuotaSoc = cuotaSoc;
        this.donacion = donacion;
        this.floresVida = floresVida;
        this.publicidad = publicidad;
        this.rifas = rifas;
        this.tarjetas = tarjetas;
        
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
        
    public ListaIngresos() {
        
    }
    
    public String getFloresVida() {
        return floresVida;
    }

    public void setFloresVida(String floresVida) {
        this.floresVida = floresVida;
    }
    
    public String getCuotaSoc() {
        return cuotaSoc;
    }  

    public void setCuotaSoc(String cuotaSoc) {
        this.cuotaSoc = cuotaSoc;
    }

    public String getDonacion() {
        return donacion;
    }

    public void setDonacion(String donacion) {
        this.donacion = donacion;
    }   

    public String getPublicidad() {
        return publicidad;
    }

    public void setPublicidad(String publicidad) {
        this.publicidad = publicidad;
    }

    public String getRifas() {
        return rifas;
    }

    public void setRifas(String rifas) {
        this.rifas = rifas;
    }

    public String getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(String tarjetas) {
        this.tarjetas = tarjetas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
}
