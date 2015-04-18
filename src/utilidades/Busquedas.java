/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import madreteresacrud.TipoSocio;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class Busquedas {

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
    

}
