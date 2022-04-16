package com.comitfy.healtie.HRModule.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee_contact")
public class ContactInfo extends BaseEntity {

    @Column
    private String phoneNumber;
    @Column
    private String phoneType;
    @Column
    private String passport;
    @Column
    private String passportValidity;
    @Column
    private String militaryStatus;
    @Column
    private String maritalStatus;
    @Column
    private String eposta;
    @Column
    private String address;
    @Column
    private String city;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
