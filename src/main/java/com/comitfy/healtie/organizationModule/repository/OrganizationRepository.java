package com.comitfy.healtie.organizationModule.repository;

import com.comitfy.healtie.organizationModule.entity.model.Department;
import com.comitfy.healtie.organizationModule.entity.model.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> getAllByName(String name);
    Organization getOrganizationById(Long id);
    List<Organization> getAllByParent_Id(Long id);
    Page<Organization> findAll(Pageable pageable);
    List<Organization> findAll(Sort sort);
}
