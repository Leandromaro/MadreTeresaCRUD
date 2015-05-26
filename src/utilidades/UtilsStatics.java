/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import madreteresacrud.TipoGasto;
import madreteresacrud.TipoSocio;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class UtilsStatics {

    private static final javax.persistence.EntityManager entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("madreTeresaCRUDPU").createEntityManager();
    private static javax.persistence.Query query1;

    public static Localidades findLocalidad(Integer idLoc) {
        String sql = "SELECT l FROM Localidades l WHERE l.idLocalidad=" + idLoc;

        query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(sql);
        return (Localidades) query1.getResultList().get(0);
    }

    public static TipoSocio findTipoSocio(Integer idTipo) {
        String sql = "SELECT t FROM TipoSocio t WHERE t.idTipoSocio=" + idTipo;

        query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(sql);
        return (TipoSocio) query1.getResultList().get(0);
    }

    public static TipoGasto findTipoGasto(Integer idTipo) {
        String sql = "SELECT t FROM TipoGasto t WHERE t.idtipoGasto=" + idTipo;
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(sql);
        return (TipoGasto) query1.getResultList().get(0);
    }

    public static Converter converterMayuscula() {
        Converter stringConverter = new Converter<String, Object>() {

            @Override
            public String convertReverse(Object value) {
                if (value != null) {
                    // return the value as is for presentation
                    return value.toString().trim().toUpperCase();
                }
                return null;
            }

            @Override
            public Object convertForward(String value) {
                if (value != null) {
                    // trim the entered value in a HtmlInputText before doing validation/updating the model
                    return value.trim().toUpperCase();
                }

                return value;

            }

        };

        return stringConverter;
    }

    /**
     * Valida la selección de fila en la tabla al insertar un nuevo registro.
     *
     * @param tabla
     * @param row
     * @param column
     */
    public static void validarSeleccion(javax.swing.JTable tabla, int row, int column) {
        if (tabla.getValueAt(row, column) == null) {
            tabla.setRowSelectionInterval(row, row);
        } else {
            for (int i = 0; i < row; i++) {
                if (tabla.getValueAt(i, column) == null) {
                    tabla.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
    }

}
