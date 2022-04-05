package com.comitfy.healtie.organizationModule.entity.model;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "org_organization")
public class Organization  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Organization parent;



}
