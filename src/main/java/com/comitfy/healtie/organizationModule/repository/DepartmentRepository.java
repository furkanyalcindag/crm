package com.comitfy.healtie.organizationModule.repository;

import com.comitfy.healtie.organizationModule.entity.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getAllByName(String name);
    Department getDepartmentById(Long id);
    Page<Department> findAll(Pageable pageable);
    List<Department> findAll(Sort sort);


}
