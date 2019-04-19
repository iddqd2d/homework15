package com.jpa.services;

import com.jpa.entity.Developer;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Log4j
public class DeveloperService implements Service<Developer> {

    public Developer read(int id) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        Developer developer = new Developer();
        try {
            entityManager.getTransaction().begin();
            developer = entityManager.find(Developer.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
        return developer;
    }

    public void create(Developer developer) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    public void update(Developer developer) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Developer developer) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(developer) ? developer : entityManager.merge(developer));
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    private void exceptionCatcher(EntityManager entityManager, RuntimeException e) {
        entityManager.getTransaction().rollback();
        log.error(e.getMessage());
    }
}
