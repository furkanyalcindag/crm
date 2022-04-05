package com.comitfy.healtie.organizationModule.controller;

import com.comitfy.healtie.organizationModule.entity.dto.EmploymentDTO;

import com.comitfy.healtie.organizationModule.service.imp.EmploymentServiceImp;
import com.comitfy.healtie.organizationModule.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/employment")
@Slf4j
public class EmploymentController {
    private final EmploymentServiceImp employmentServiceImp;

    EmploymentController(EmploymentServiceImp employmentServiceImp) {
        this.employmentServiceImp = employmentServiceImp;
    }

    @PostMapping
    public ResponseEntity<EmploymentDTO> createProject(@Valid @RequestBody EmploymentDTO projectDTO) throws IllegalAccessException {
        return ResponseEntity.ok(employmentServiceImp.save(projectDTO));
    }

    @GetMapping()
    public ResponseEntity<TPage<EmploymentDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(employmentServiceImp.getAllPageable(pageable));
    }




}
