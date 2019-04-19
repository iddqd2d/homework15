package com.jpa.services;

import com.jpa.entity.Project;
import com.jpa.entity.Project;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


@Log4j
public class ProjectService implements Service<Project> {

    public Project read(int id) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        Project project = new Project();
        try {
            entityManager.getTransaction().begin();
            project = entityManager.find(Project.class, id);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            exceptionCatcher(entityManager, e);
        } finally {
            entityManager.close();
        }
        return project;
    }

    public void create(Project project) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            exceptionCatcher(entityManager, e);
        } finally {
            entityManager.close();
        }
    }

    public void update(Project project) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(project);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            exceptionCatcher(entityManager, e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Project project) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(project) ? project : entityManager.merge(project));
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            exceptionCatcher(entityManager, e);
        } finally {
            entityManager.close();
        }
    }

    private void exceptionCatcher(EntityManager entityManager, RuntimeException e) {
        entityManager.getTransaction().rollback();
        log.error(e.getMessage());
    }
}
