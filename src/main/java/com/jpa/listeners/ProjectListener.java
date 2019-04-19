package com.jpa.listeners;

import com.jpa.entity.Project;
import lombok.extern.log4j.Log4j;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;

@Log4j
public class ProjectListener {
    @PrePersist
    public void prePersist(Project o) {
        log.info("Pre-Persistiting operation: " + o.getName());
    }

    @PostPersist
    public void postPersist(Project o) {
        log.info("Post-Persist operation: " + o.getName());
    }

    @PreRemove
    public void preRemove(Project o) {
        log.info("Pre-Removing operation: " + o.getName());
    }

    @PostRemove
    public void postRemove(Project o) {
        log.info("Post-Remove operation: " + o.getName());
    }

    @PreUpdate
    public void preUpdate(Project o) {
        log.info("Pre-Updating operation: " + o.getName());
    }

    @PostUpdate
    public void postUpdate(Project o) {
        log.info("Post-Update operation: " + o.getName());
    }
}
