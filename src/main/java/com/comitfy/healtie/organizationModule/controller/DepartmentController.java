package com.comitfy.healtie.organizationModule.controller;

import com.comitfy.healtie.organizationModule.entity.dto.DepartmentDTO;
import com.comitfy.healtie.organizationModule.service.imp.DepartmentServiceImp;
import com.comitfy.healtie.organizationModule.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/department")
@Slf4j
public class DepartmentController {
    private final DepartmentServiceImp departmentServiceImp;

    DepartmentController(DepartmentServiceImp departmentServiceImp) {
        this.departmentServiceImp = departmentServiceImp;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createProject(@Valid @RequestBody DepartmentDTO projectDTO) throws IllegalAccessException {
        return ResponseEntity.ok(departmentServiceImp.save(projectDTO));
    }

    @GetMapping()
    public ResponseEntity<TPage<DepartmentDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(departmentServiceImp.getAllPageable(pageable));
    }
}
