package com.jpa.entity;

import com.jpa.listeners.ProjectListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import java.util.List;

@Log4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(ProjectListener.class)
@Table(name = "projects")
public class Project extends AbstractIdentifiableObject{

    @Column
    private String name;

    @Column
    private Integer cost;

    @ManyToMany(mappedBy = "projects")
    private List<Developer> developers;
}
