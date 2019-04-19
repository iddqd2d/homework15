package com.jpa.listeners;

import com.jpa.entity.Developer;
import lombok.extern.log4j.Log4j;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;

@Log4j
public class DeveloperListener {
    @PrePersist
    public void prePersist(Developer o) {
        log.info("Pre-Persistiting operation: " + o.getName());
    }

    @PostPersist
    public void postPersist(Developer o) {
        log.info("Post-Persist operation: " + o.getName());
    }

    @PreRemove
    public void preRemove(Developer o) {
        log.info("Pre-Removing operation: " + o.getName());
    }

    @PostRemove
    public void postRemove(Developer o) {
        log.info("Post-Remove operation: " + o.getName());
    }

    @PreUpdate
    public void preUpdate(Developer o) {
        log.info("Pre-Updating operation: " + o.getName());
    }

    @PostUpdate
    public void postUpdate(Developer o) {
        log.info("Post-Update operation: " + o.getName());
    }
}
