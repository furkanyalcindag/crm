package com.comitfy.healtie.organizationModule.service.imp;

import com.comitfy.healtie.organizationModule.entity.dto.OrganizationDTO;
import com.comitfy.healtie.organizationModule.entity.model.Organization;
import com.comitfy.healtie.organizationModule.repository.OrganizationRepository;
import com.comitfy.healtie.organizationModule.service.OrganizationService;
import com.comitfy.healtie.organizationModule.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrganizationServiceImp implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    public OrganizationServiceImp(OrganizationRepository organizationRepository,
                                  ModelMapper modelMapper) {
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrganizationDTO save(OrganizationDTO organizationDTO) throws IllegalAccessException {
        Organization organization = modelMapper.map(organizationDTO, Organization.class);
        organizationRepository.save(organization);
        return modelMapper.map(organization, OrganizationDTO.class);
    }

    @Override
    public OrganizationDTO getOrganizationByName(String name) {
        return null;
    }

    @Override
    public OrganizationDTO update(Long id, OrganizationDTO organizationDTO) {
        return null;
    }

    @Override
    public OrganizationDTO getById(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if(organizationRepository.getAllByParent_Id(id).size()>0)
        {
            //TO DO exception gelecek
            return false;
        }else {
             organizationRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public TPage<OrganizationDTO> getAllPageable(Pageable pageable) {
        Page<Organization> data = organizationRepository.findAll(pageable);
        TPage<OrganizationDTO> respnose = new TPage<OrganizationDTO>();
        respnose.setStart(data, Arrays.asList(modelMapper.map(data.getContent(), OrganizationDTO[].class)));
        return respnose;
    }
}
