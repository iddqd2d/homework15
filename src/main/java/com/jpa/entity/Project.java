package com.jpa.entity;

import com.jpa.listeners.ProjectListener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import java.util.List;

@Log4j
@Data
@NoArgsConstructor
@Entity
@EntityListeners(ProjectListener.class)
@Table(name = "projects")
public class Project extends AbstractIdentifiableObject{

    @Column
    private String name;

    @Column
    private int cost;

    @ManyToMany(mappedBy = "projects")
    private List<Developer> developers;

    public Project(String name, int cost){
        this.name = name;
        this.cost = cost;
    }
}
