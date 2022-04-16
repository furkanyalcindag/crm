package com.comitfy.healtie.organizationModule.service.imp;

import com.comitfy.healtie.organizationModule.entity.dto.DepartmentDTO;
import com.comitfy.healtie.organizationModule.entity.model.Department;
import com.comitfy.healtie.organizationModule.repository.DepartmentRepository;
import com.comitfy.healtie.organizationModule.service.DepartmentService;
import com.comitfy.healtie.organizationModule.util.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImp(DepartmentRepository departmentRepository,
                                ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) throws IllegalAccessException {
        Department project = modelMapper.map(departmentDTO, Department.class);
        departmentRepository.save(project);
        return modelMapper.map(project, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getById(Long id) {
        return null;
    }

    @Override
    public DepartmentDTO getDepartmentByName(String name) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public DepartmentDTO update(Long id, DepartmentDTO departmentDTO) {
        return null;
    }

    @Override
    public PageDTO<DepartmentDTO> getAllPageable(Pageable pageable) {
        Page<Department> data = departmentRepository.findAll(pageable);
        PageDTO<DepartmentDTO> response = new PageDTO<>();
        response.setStart(data, Arrays.asList(modelMapper.map(data.getContent(), DepartmentDTO[].class)));
        return response;
    }
}
