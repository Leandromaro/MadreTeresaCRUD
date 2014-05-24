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
    private String cuotaSoc;
    private String donacion;

    public ListaIngresos(String mes, String cuotaSoc, String donacion) {
        this.mes = mes;
        this.cuotaSoc = cuotaSoc;
        this.donacion = donacion;
    }
    public ListaIngresos() {
        
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

   

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }


    
}
