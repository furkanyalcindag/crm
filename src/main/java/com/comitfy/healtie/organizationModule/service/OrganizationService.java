package com.comitfy.healtie.organizationModule.service;

import com.comitfy.healtie.organizationModule.entity.dto.OrganizationDTO;
import com.comitfy.healtie.organizationModule.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {
    OrganizationDTO save(OrganizationDTO organizationDTO) throws IllegalAccessException;
    OrganizationDTO getById(Long id);
    OrganizationDTO getOrganizationByName(String name);
    Boolean delete(Long id);
    OrganizationDTO update(Long id, OrganizationDTO organizationDTO);
    TPage<OrganizationDTO> getAllPageable(Pageable pageable);
}
