package com.comitfy.healtie.organizationModule.service;

import com.comitfy.healtie.organizationModule.entity.dto.DepartmentDTO;
import com.comitfy.healtie.organizationModule.util.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService  {
    DepartmentDTO save(DepartmentDTO departmentDTO) throws IllegalAccessException;

    DepartmentDTO getById(Long id);
    DepartmentDTO getDepartmentByName(String name);
    Boolean delete(Long id);
    DepartmentDTO update(Long id, DepartmentDTO departmentDTO);
    PageDTO<DepartmentDTO> getAllPageable(Pageable pageable);
}
