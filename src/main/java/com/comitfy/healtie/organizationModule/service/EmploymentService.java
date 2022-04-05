package com.comitfy.healtie.organizationModule.service;

import com.comitfy.healtie.organizationModule.entity.dto.EmploymentDTO;
import com.comitfy.healtie.organizationModule.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EmploymentService {
    EmploymentDTO save(EmploymentDTO departmentDTO) throws IllegalAccessException;
    EmploymentDTO getById(Long id);
    EmploymentDTO getDepartmentByName(String name);
    Boolean delete(Long id);
    EmploymentDTO update(Long id, EmploymentDTO departmentDTO);
    TPage<EmploymentDTO> getAllPageable(Pageable pageable);
}
