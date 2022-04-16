package com.comitfy.healtie.HRModule.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee_education")
public class EducationInfo extends BaseEntity {

    @Column
    private Date startDate;//ay-yıl şeklinde alınmalı
    @Column
    private Date endDate;//ay-yıl şeklinde alınmalı
    @Column
    private String schoolsName;
    @Column
    private String schoolType;
    @Column
    private String department;
    @Column
    private double graduationGrade;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}
