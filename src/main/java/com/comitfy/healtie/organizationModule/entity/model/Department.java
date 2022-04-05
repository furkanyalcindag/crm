package com.comitfy.healtie.organizationModule.entity.model;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "org_department")
public class Department  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String organizationId;
    @Column
    private String headOfDepartment;
    @Column
    private String parentId;

    @ManyToMany
    @JoinTable(name="org_employment_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name="employment_id")
    )
    private List<Employment> employmentList = new ArrayList<Employment>();

}
