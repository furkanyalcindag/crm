package com.comitfy.healtie.organizationModule.entity.model;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "org_employment")
public class Employment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

          @Column
          private String userId;
          @Column
          private String startDate;
          @Column
          private String endDate;
          @Column
          private String employeeCode;
          @Column
          private String role;
          @Column
          private String departmentId;
          @Transient
          private String organizationId;

          @ManyToMany
          @JoinTable(name="org_employment_department",
                joinColumns = @JoinColumn(name = "employment_id"),
                inverseJoinColumns = @JoinColumn(name="department_id")
         )
         private List<Department> departmentList = new ArrayList<Department>();


}
