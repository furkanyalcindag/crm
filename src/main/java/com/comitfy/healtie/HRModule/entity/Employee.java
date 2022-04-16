package com.comitfy.healtie.HRModule.entity;


import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "employee")
public class Employee extends BaseEntity {

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToMany(mappedBy = "contact")
    private Set<ContactInfo> contactInfoSet;

    @OneToMany(mappedBy = "family")
    private Set<FamilyInfo> familyInfoSet;

    @OneToMany(mappedBy = "education")
    private Set<EducationInfo> educationInfoSet;


}
