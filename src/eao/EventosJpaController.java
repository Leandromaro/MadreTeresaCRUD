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
import madreteresacrud.Eventos;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class EventosJpaController implements Serializable {

    public EventosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Eventos eventos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eventos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Eventos eventos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eventos = em.merge(eventos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = eventos.getIdEvento();
                if (findEventos(id) == null) {
                    throw new NonexistentEntityException("The eventos with id " + id + " no longer exists.");
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
            Eventos eventos;
            try {
                eventos = em.getReference(Eventos.class, id);
                eventos.getIdEvento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eventos with id " + id + " no longer exists.", enfe);
            }
            em.remove(eventos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Eventos> findEventosEntities() {
        return findEventosEntities(true, -1, -1);
    }

    public List<Eventos> findEventosEntities(int maxResults, int firstResult) {
        return findEventosEntities(false, maxResults, firstResult);
    }

    private List<Eventos> findEventosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Eventos as o order by o.fecha DESC");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Eventos findEventos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Eventos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEventosCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Eventos as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Eventos> findByRangeDate(String fDesde, String fHasta){
         EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Eventos as o WHERE o.fecha BETWEEN '"+fDesde+"' AND '"+fHasta+"' order by o.fecha DESC");            
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
