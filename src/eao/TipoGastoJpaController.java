/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eao;

import eao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import madreteresacrud.TipoGasto;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class TipoGastoJpaController implements Serializable {

    public TipoGastoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoGasto tipoGasto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoGasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoGasto tipoGasto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoGasto = em.merge(tipoGasto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoGasto.getIdtipoGasto();
                if (findTipoGasto(id) == null) {
                    throw new NonexistentEntityException("The tipoGasto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoGasto tipoGasto;
            try {
                tipoGasto = em.getReference(TipoGasto.class, id);
                tipoGasto.getIdtipoGasto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoGasto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoGasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoGasto> findTipoGastoEntities() {
        return findTipoGastoEntities(true, -1, -1);
    }

    public List<TipoGasto> findTipoGastoEntities(int maxResults, int firstResult) {
        return findTipoGastoEntities(false, maxResults, firstResult);
    }

    private List<TipoGasto> findTipoGastoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from TipoGasto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoGasto findTipoGasto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoGasto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoGastoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from TipoGasto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
