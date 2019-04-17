package com.jpa.services;

import com.jpa.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProjectService implements DAO<Project> {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

    public Project read(int id) {
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return project;
    }

    public void create(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Project project) {
        entityManager.getTransaction().begin();
        entityManager.remove(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
