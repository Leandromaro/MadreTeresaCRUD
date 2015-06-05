/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eao;

import eao.exceptions.NonexistentEntityException;
import eao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import madreteresacrud.TipoEvento;
import madreteresacrud.TipoEvento_;

/**
 *
 * @author Francisco M. Viola <francimviola@gmail.com>
 */
public class TipoEventoJpaController implements Serializable {

    public TipoEventoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoEvento tipoEvento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoEvento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoEvento(tipoEvento.getIdTipoEvento()) != null) {
                throw new PreexistingEntityException("TipoEvento " + tipoEvento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoEvento tipoEvento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoEvento = em.merge(tipoEvento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoEvento.getIdTipoEvento();
                if (findTipoEvento(id) == null) {
                    throw new NonexistentEntityException("The tipoEvento with id " + id + " no longer exists.");
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
            TipoEvento tipoEvento;
            try {
                tipoEvento = em.getReference(TipoEvento.class, id);
                tipoEvento.getIdTipoEvento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoEvento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoEvento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoEvento> findTipoEventoEntities() {
        return findTipoEventoEntities(true, -1, -1);
    }

    public List<TipoEvento> findTipoEventoEntities(int maxResults, int firstResult) {
        return findTipoEventoEntities(false, maxResults, firstResult);
    }

    private List<TipoEvento> findTipoEventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from TipoEvento as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoEvento findTipoEvento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoEvento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoEventoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from TipoEvento as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public TipoEvento findEventoByDescripcion(String descrip) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TipoEvento> cq = cb.createQuery(TipoEvento.class);
        Root<TipoEvento> root = cq.from(TipoEvento.class);
        cq.select(root);
        Predicate p = cb.equal(root.get(TipoEvento_.descripcion), descrip);
        cq.where(p);
        TypedQuery<TipoEvento> q = getEntityManager().createQuery(cq);
        q.setMaxResults(1);
        List<TipoEvento> usuariosList = q.getResultList();
        if (!usuariosList.isEmpty()) {
            return usuariosList.get(0);
        }
        return null;
    }

    
}
