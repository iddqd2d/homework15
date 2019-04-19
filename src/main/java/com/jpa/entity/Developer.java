package com.jpa.entity;

import com.jpa.listeners.DeveloperListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(DeveloperListener.class)
@Table(name = "developers")
public class Developer extends AbstractIdentifiableObject{

    @Column
    private String name;

    @Column
    private Integer age;

    @Column(name = "sex")
    private boolean isMale;

    @Column
    private Integer salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "developers_projects",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
   private List<Project> projects;
}
