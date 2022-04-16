package com.comitfy.healtie.HRModule.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee_family")
public class FamilyInfo extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String relationshipDegree ;//dropdown
    @Column
    private Date birthDate;
    @Column
    private String phoneNumber;
    @Column
    private String gender;//dropdown
    @Column
    private String maritalStatus ;//dropdown
    @Column
    private boolean isWorking;




    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
