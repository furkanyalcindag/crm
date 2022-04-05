package com.comitfy.healtie.organizationModule.entity.dto;

import com.comitfy.healtie.organizationModule.entity.model.Employment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private String description;
    private String organizationId;
    private String headOfDepartment;
    private String parentId;
    private List<Employment> employmentList ;
}
