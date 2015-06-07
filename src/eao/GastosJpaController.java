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
import madreteresacrud.Gastos;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class GastosJpaController implements Serializable {

    public GastosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gastos gastos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gastos gastos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gastos = em.merge(gastos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gastos.getIdgastos();
                if (findGastos(id) == null) {
                    throw new NonexistentEntityException("The gastos with id " + id + " no longer exists.");
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
            Gastos gastos;
            try {
                gastos = em.getReference(Gastos.class, id);
                gastos.getIdgastos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gastos with id " + id + " no longer exists.", enfe);
            }
            em.remove(gastos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gastos> findGastosEntities() {
        return findGastosEntities(true, -1, -1);
    }

    public List<Gastos> findGastosEntities(int maxResults, int firstResult) {
        return findGastosEntities(false, maxResults, firstResult);
    }

    private List<Gastos> findGastosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Gastos as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gastos findGastos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gastos.class, id);
        } finally {
            em.close();
        }
    }

    public int getGastosCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Gastos as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
