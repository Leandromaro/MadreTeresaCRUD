/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author francis
 */
public class ListaEgresos {
    private String monto;
    private String mes;
    private String anio;

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    private String item;

    public ListaEgresos(String mes, String anio, String item, String monto) {        
        this.mes = mes;
        this.anio=anio;
        this.item = item;
        this.monto = monto;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}
