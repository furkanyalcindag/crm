package com.comitfy.healtie.organizationModule.entity.dto;

import com.comitfy.healtie.organizationModule.entity.model.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
    private Long id;
    private String name;
    private String description;
    private Organization parent;
}
