package com.jpa.entity;

import com.jpa.listeners.DeveloperListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(DeveloperListener.class)
@Table(name = "developers")
public class Developer extends AbstractIdentifiableObject{

    @Column
    private String name;

    @Column
    private int age;

    @Column(name = "sex")
    private boolean isMale;

    @Column
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "developers_projects",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Developer(String name, int age, boolean isMale, int salary) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.salary = salary;
    }
}
