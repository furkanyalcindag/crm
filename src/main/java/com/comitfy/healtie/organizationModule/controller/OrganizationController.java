package com.comitfy.healtie.organizationModule.controller;

import com.comitfy.healtie.organizationModule.entity.dto.OrganizationDTO;
import com.comitfy.healtie.organizationModule.service.imp.OrganizationServiceImp;
import com.comitfy.healtie.organizationModule.util.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/organization")
@Slf4j
public class OrganizationController {
    private final OrganizationServiceImp organizationServiceImp;

    OrganizationController(OrganizationServiceImp organizationServiceImp) {
        this.organizationServiceImp = organizationServiceImp;
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@Valid @RequestBody OrganizationDTO projectDTO)
            throws IllegalAccessException {
        return ResponseEntity.ok(organizationServiceImp.save(projectDTO));
    }

    @GetMapping("pagination")
    public ResponseEntity<PageDTO<OrganizationDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(organizationServiceImp.getAllPageable(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(organizationServiceImp.delete(id));
    }
}
