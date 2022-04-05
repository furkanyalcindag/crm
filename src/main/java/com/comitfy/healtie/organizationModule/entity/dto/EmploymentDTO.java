package com.comitfy.healtie.organizationModule.entity.dto;

import com.comitfy.healtie.organizationModule.entity.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentDTO {
    private Long id;
    private String userId;
    private String startDate;
    private String endDate;
    private String employeeCode;
    private String role;
    private String departmentId;
    private List<Department> departmentList ;
}
