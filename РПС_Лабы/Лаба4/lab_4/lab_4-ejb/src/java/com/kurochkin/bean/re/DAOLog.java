/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kurochkin.bean.re;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mikhail
 */
@Stateless
public class DAOLog implements IDAOLog {
    
    @PersistenceContext(unitName="UniverEjbPU")
    private EntityManager entityManager; 

    @Override
    public List<LogEntity> getAll() {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(LogEntity.class));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public void add(LogEntity s) {
        entityManager.persist(s);
    }

    @Override
    public LogEntity getById(int id) {
        return entityManager.find(LogEntity.class, id);
    }

    @Override
    public void delete(LogEntity s) {
         entityManager.remove(entityManager.merge(s));
    }

    @Override
    public void update(LogEntity s) {
        entityManager.merge(s);  
    }
    
}
