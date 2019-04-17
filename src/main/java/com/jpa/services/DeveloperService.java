package com.jpa.services;

import com.jpa.entity.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeveloperService implements DAO<Developer>{
    private EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

    public Developer read(int id) {
        entityManager.getTransaction().begin();
        Developer developer = entityManager.find(Developer.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return developer;
    }

    public void create(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.merge(developer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.remove(developer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
