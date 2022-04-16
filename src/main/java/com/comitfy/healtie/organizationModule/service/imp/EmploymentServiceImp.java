package com.comitfy.healtie.organizationModule.service.imp;

import com.comitfy.healtie.organizationModule.entity.dto.DepartmentDTO;
import com.comitfy.healtie.organizationModule.entity.dto.EmploymentDTO;
import com.comitfy.healtie.organizationModule.entity.dto.OrganizationDTO;
import com.comitfy.healtie.organizationModule.entity.model.Department;
import com.comitfy.healtie.organizationModule.entity.model.Employment;
import com.comitfy.healtie.organizationModule.entity.model.Organization;
import com.comitfy.healtie.organizationModule.repository.DepartmentRepository;
import com.comitfy.healtie.organizationModule.repository.EmploymentRepository;
import com.comitfy.healtie.organizationModule.service.DepartmentService;
import com.comitfy.healtie.organizationModule.service.EmploymentService;
import com.comitfy.healtie.organizationModule.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmploymentServiceImp implements EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final ModelMapper modelMapper;

    public EmploymentServiceImp(EmploymentRepository employmentRepository,
                                ModelMapper modelMapper) {
        this.employmentRepository = employmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmploymentDTO save(EmploymentDTO employmentDTO) throws IllegalAccessException {
        Employment project = modelMapper.map(employmentDTO, Employment.class);
        employmentRepository.save(project);
        return modelMapper.map(project, EmploymentDTO.class);
    }

    @Override
    public EmploymentDTO getById(Long id) {
        return null;
    }

    @Override
    public EmploymentDTO getDepartmentByName(String name) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        employmentRepository.deleteById(id);
        return true;
    }

    @Override
    public EmploymentDTO update(Long id, EmploymentDTO departmentDTO) {
        return null;
    }

    @Override
    public TPage<EmploymentDTO> getAllPageable(Pageable pageable) {
        Page<Employment> data = employmentRepository.findAll(pageable);
        TPage<EmploymentDTO> respnose = new TPage<EmploymentDTO>();
        respnose.setStart(data, Arrays.asList(modelMapper.map(data.getContent(), EmploymentDTO[].class)));
        return respnose;
    }
}
