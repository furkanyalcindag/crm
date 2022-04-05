package com.comitfy.healtie.organizationModule.repository;
import com.comitfy.healtie.organizationModule.entity.model.Employment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    Page<Employment> findAll(Pageable pageable);
    List<Employment> findAll(Sort sort);


}
