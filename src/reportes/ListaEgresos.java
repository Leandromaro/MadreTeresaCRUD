/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.math.BigDecimal;

/**
 *
 * @author francis
 */
public class ListaEgresos {
    private BigDecimal monto;
    private String item;
    private Integer mes;
    private Integer anio;

    public ListaEgresos(Integer mes, Integer anio,String item,BigDecimal monto) {
        this.monto = monto;
        this.item = item;
        this.mes = mes;
        this.anio = anio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

   
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}
